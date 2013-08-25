package com.antwerkz.jpa.jpa.dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.antwerkz.jpa.jpa.model.Product;
import com.antwerkz.jpa.jpa.model.ProductOrder;
import com.antwerkz.jpa.jpa.model.User;
import com.google.inject.persist.Transactional;

@SuppressWarnings("unchecked")
public class JpaDao {
    @Inject
    private EntityManager em;

    @Transactional
    public void save(Object entity) {
        em.persist(entity);
        em.flush();
    }

    @Transactional
    public void clearAll() {
        System.out.println("Clearing all data");
        deleteOrders();
        em.createQuery("delete from Product").executeUpdate();
        em.createQuery("delete from User cascade").executeUpdate();
        em.createQuery("delete from Address").executeUpdate();
    }

    private void deleteOrders() {
        for (ProductOrder order : (List<ProductOrder>) em.createQuery("from ProductOrder").getResultList()) {
            order.setProducts(null);
            save(order);
            em.remove(order);
        }
        em.flush();
    }

    public User findUser(final String email) {
        return (User) em.createQuery("from User u where u.email=:email").setParameter("email", email)
            .getSingleResult();
    }

    public Product findProduct(final String name) {
        return (Product) em.createQuery("from Product p where p.name=:name").setParameter("name", name)
            .getSingleResult();
    }

    public List<ProductOrder> findOrdersOver(final double total) {
        Query query = em.createQuery("select o from ProductOrder o join o.products p group by o having sum(p.price) > :total"
            + " order by sum(p.price)")
            .setParameter("total", total);
        return query.getResultList();
    }

    public List<ProductOrder> findSmallOrders(final long count) {
        Query query = em.createQuery("select o from ProductOrder o join o.products p group by o having count(p) <= :count")
            .setParameter("count", count);
        return query.getResultList();
    }

    public List<User> findByHairColor(final String color) {
        Query query = em.createQuery("from User u where u.hairColor = :color")
            .setParameter("color", color);
        return query.getResultList();
    }
}
