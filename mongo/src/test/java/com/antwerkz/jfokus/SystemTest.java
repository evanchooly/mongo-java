package com.antwerkz.jfokus;

import java.util.Date;
import java.util.List;

import com.antwerkz.jfokus.jpa.model.Address;
import com.antwerkz.jfokus.jpa.model.Product;
import com.antwerkz.jfokus.jpa.model.ProductOrder;
import com.antwerkz.jfokus.jpa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class SystemTest extends BaseTest {
    public void placeOrder() {
        orderForDave();
        orderForJules();
        orderForBruce();

        List<ProductOrder> orders = dao.findOrdersOver(10000.0);
        Assert.assertEquals(orders.get(0).getUserId().getFirstName(), "Jules");

        List<ProductOrder> smallOrders = dao.findSmallOrders(2);
        ProductOrder smallOrder = smallOrders.get(0);
        Assert.assertEquals(smallOrder.getUserId().getFirstName(), "David");
        Assert.assertTrue(smallOrder.getProducts().size() <= 2);
        try {
            Assert.assertNull(dao.findByHairColor("red"));
        } catch (Exception e) {
        }
    }

    private void print(final List<ProductOrder> orders) {
        for (ProductOrder order : orders) {
            System.out.println("order = " + order);
            double total = 0;
            for (Product product : order.getProducts()) {
                total += product.getPrice();
            }
            System.out.println("total = " + total);
        }
    }

    private void orderForBruce() {
        ProductOrder order = new ProductOrder();
        order.setUserId(dao.findUser("bruce@wayne.com"));
        order.setOrderDate(new Date(112, 1, 1));
        order.add(dao.findProduct("Quadtech"));
        order.add(dao.findProduct("Biolux"));
        order.add(dao.findProduct("Bigzamnix"));
        order.setFulfilled(true);
        dao.save(order);
    }

    private void orderForDave() {
        ProductOrder order = new ProductOrder();
        order.setUserId(dao.findUser("dbowman@jpl.nasa.gov"));
        order.setOrderDate(new Date(112, 6, 15));
        order.add(dao.findProduct("Spacesuit"));
        order.add(dao.findProduct("Computer Repair for Rocket Scientists (Hardcover)"));
        order.setFulfilled(true);
        dao.save(order);
    }

    private void orderForJules() {
        ProductOrder order = new ProductOrder();
        order.setUserId(dao.findUser("jules@hotmail.com"));
        order.setOrderDate(new Date(112, 8, 27));
        order.add(dao.findProduct("Tiptone"));
        order.add(dao.findProduct("Bigzamnix"));
        order.add(dao.findProduct("Bio Air"));
        order.add(dao.findProduct("Roundtough"));
        dao.save(order);
    }

    @BeforeClass
    private void createUser() {
        createUserWithAddress("David", "Bowman", "dbowman@jpl.nasa.gov", "123 Rocket Ln", "Houston", "TX", "77058");
        createUserWithAddress("Heywood", "Floyd", "hfloyd@jpl.nasa.gov", "2101 NASA Road 1", "Cape Canaveral", "FL", "32920");
        createUserWithAddress("Bruce", "Wayne", "bruce@wayne.com", "1 Wayne Road", "Gotham", "NY", "10014");
        createUserWithAddress("Walter", "Sobchak", "walter@geemail.com", "1760 Hillhurst Ave", "Los Angeles", "CA", "90001");
        createUserWithAddress("Jules", "Winnfield", "jules@hotmail.com", "1858 N Vermont Ave", "Los Angeles", "CA", "90027");
    }

    private void createUserWithAddress(final String firstName, final String lastName, final String email,
        final String street, final String city, final String state, final String zip) {
        User user = new User(firstName, lastName, email);
        user.getAddresses().add(createAddress(street, city, state, zip));
        dao.save(user);
    }

    private Address createAddress(final String street, final String city, final String state,
        final String zip) {
        Address address = new Address(street, city, state, zip);
        dao.save(address);
        return address;
    }

    @BeforeClass
    public void createCatalog() {
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
