package org.codekafe.service;

import org.codekafe.model.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Transactional
    public Product getProductById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public Product createProduct(Product product) {
        if (product.getId() != null && entityManager.find(Product.class, product.getId()) != null) {
            return entityManager.merge(product);
        } else {
            entityManager.persist(product);
            return product;
        }
    }

    @Transactional
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = entityManager.find(Product.class, id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return entityManager.merge(existingProduct);
        }
        return null;
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
