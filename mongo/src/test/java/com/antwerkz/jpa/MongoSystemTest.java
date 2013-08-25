package com.antwerkz.jpa;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

import com.antwerkz.MongoModule;
import com.antwerkz.mongo.dao.MongoDao;
import com.antwerkz.mongo.model.Address;
import com.antwerkz.mongo.model.Product;
import com.antwerkz.mongo.model.ProductOrder;
import com.antwerkz.mongo.model.User;
import com.mongodb.DB;
import org.bson.types.ObjectId;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
@Test
@Guice(modules = {MongoModule.class})
public class MongoSystemTest {
  @Inject
  private DB db;

  @Inject
  protected MongoDao dao;

  public void placeOrder() {
    orderForDave();
    orderForJules();
    orderForBruce();
    List<ProductOrder> orders = dao.findOrdersOver(10000.0);
    ObjectId userId = orders.get(0).getUserId();
    Assert.assertEquals(dao.findUserWithMorphia(userId).getFirstName(), "Jules");
    Assert.assertEquals(dao.findUserWithJongo(userId).getFirstName(), "Jules");
    List<ProductOrder> smallOrders = dao.findSmallOrders(2);
    ProductOrder smallOrder = smallOrders.get(0);
    userId = smallOrder.getUserId();
    User user = dao.findUserWithMorphia(userId);
    Assert.assertEquals(user.getFirstName(), "David");
    Assert.assertTrue(smallOrder.getProducts().size() <= 2);
    try {
      Assert.assertNotNull(dao.findByHairColor("red"));
    } catch (Exception e) {
    }
  }

  @Test(dependsOnMethods = "placeOrder")
  public void compareQueryLayers() {
    List<ProductOrder> orders = dao.findOrdersOver(10000.0);
    List<ProductOrder> morphia = dao.findOrdersOverWithMorphia(10000.0);
    Iterable<ProductOrder> jongo = dao.findOrdersOverWithJongo(10000.0);
    List<ProductOrder> critter = dao.findOrdersOverWithCritter(10000.0);
    Assert.assertEquals(orders.size(), 2);
    compare(orders, morphia);
    compare(orders, critter);
    compare(orders, jongo);
  }

  private void compare(final List<ProductOrder> orders, final Iterable<ProductOrder> iterable) {
    Iterator<ProductOrder> iterator = iterable.iterator();
    for (ProductOrder order : orders) {
      Assert.assertEquals(iterator.next(), order);
    }
  }

  private void orderForBruce() {
    ProductOrder order = new ProductOrder();
    order.setUserId(dao.findUserByEmail("bruce@wayne.com").getId());
    order.setOrderDate(new Date(112, 1, 1));
    order.add(dao.findProduct("Quadtech"));
    order.add(dao.findProduct("Biolux"));
    order.add(dao.findProduct("Bigzamnix"));
    order.setFulfilled(true);
    dao.save(order);
  }

  private void orderForDave() {
    ProductOrder order = new ProductOrder();
    order.setUserId(dao.findUserByEmail("dbowman@jpl.nasa.gov").getId());
    order.setOrderDate(new Date(112, 6, 15));
    order.add(dao.findProduct("Spacesuit"));
    order.add(dao.findProduct("Computer Repair for Rocket Scientists (Hardcover)"));
    order.setFulfilled(true);
    dao.save(order);
  }

  private void orderForJules() {
    ProductOrder order = new ProductOrder();
    order.setUserId(dao.findUserByEmail("jules@hotmail.com").getId());
    order.setOrderDate(new Date(112, 8, 27));
    order.add(dao.findProduct("Tiptone"));
    order.add(dao.findProduct("Bigzamnix"));
    order.add(dao.findProduct("Bio Air"));
    order.add(dao.findProduct("Roundtough"));
    dao.save(order);
  }

  private void createUserWithAddress(final String firstName, final String lastName, final String email,
      final String street, final String city, final String state, final String zip) {
    User user = new User(firstName, lastName, email);
    user.getAddresses().add(new Address(street, city, state, zip));
    dao.save(user);
  }

  @BeforeTest
  private void createDataSet() {
    dao.clearAll();
    createUser();
    createCatalog();
  }

  private void createUser() {
    createUserWithAddress("David", "Bowman", "dbowman@jpl.nasa.gov", "123 Rocket Ln", "Houston", "TX", "77058");
    createUserWithAddress("Heywood", "Floyd", "hfloyd@jpl.nasa.gov", "2101 NASA Road 1", "Cape Canaveral", "FL",
        "32920");
    createUserWithAddress("Bruce", "Wayne", "bruce@wayne.com", "1 Wayne Road", "Gotham", "NY", "10014");
    createUserWithAddress("Walter", "Sobchak", "walter@geemail.com", "1760 Hillhurst Ave", "Los Angeles", "CA",
        "90001");
    createUserWithAddress("Jules", "Winnfield", "jules@hotmail.com", "1858 N Vermont Ave", "Los Angeles", "CA",
        "90027");
  }

  private void createCatalog() {
    dao.save(new Product("Spacesuit", 8693.0));
    dao.save(new Product("Macbook Pro", 4988.0));
    dao.save(new Product("Computer Repair for Rocket Scientists (Hardcover)", 23.45));
    dao.save(new Product("The Hitchhiker's Guide to the Galaxy", 10.20));
    dao.save(new Product("La Dex", 343.58));
    dao.save(new Product("Tiptone", 688.05));
    dao.save(new Product("Plus Tex", 986.25));
    dao.save(new Product("Zamstrong", 568.90));
    dao.save(new Product("Techla", 751.33));
    dao.save(new Product("Roundtough", 584.37));
    dao.save(new Product("Bio Home", 742.36));
    dao.save(new Product("Solfind", 415.08));
    dao.save(new Product("Biolux", 605.08));
    dao.save(new Product("Fun-Bam", 5327.44));
    dao.save(new Product("Temp-Dax", 9764.73));
    dao.save(new Product("Yearphase", 73.70));
    dao.save(new Product("Quadtech", 1711.26));
    dao.save(new Product("Rontough", 896.90));
    dao.save(new Product("Kintamtone", 9870.5));
    dao.save(new Product("Joy String", 9429.36));
    dao.save(new Product("Quadfan", 6490.69));
    dao.save(new Product("Roundlotfind", 437.01));
    dao.save(new Product("Bigzamnix", 22677.33));
    dao.save(new Product("Nimin", 7610.94));
    dao.save(new Product("Geo Tax", 273.47));
    dao.save(new Product("Bio Air", 363.26));
  }
}
