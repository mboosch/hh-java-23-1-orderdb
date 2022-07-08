package de.neuefische.rem214orderdb.repo;

import de.neuefische.rem214orderdb.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        throw new NoSuchElementException("Prduct with id: " + id + " not found!");
    }
}
