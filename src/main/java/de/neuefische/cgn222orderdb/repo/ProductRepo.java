package de.neuefische.cgn222orderdb.repo;

import de.neuefische.cgn222orderdb.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductRepo {
    private final List<Product> products;

    public ProductRepo(List<Product> products) {
        this.products = Collections.unmodifiableList(products);
    }

    public List<Product> listProducts() {
        return products;
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new NoSuchElementException("Product with id: " + id + " not found!");
    }
}
