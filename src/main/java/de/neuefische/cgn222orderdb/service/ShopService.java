package de.neuefische.cgn222orderdb.service;

import de.neuefische.cgn222orderdb.model.Order;
import de.neuefische.cgn222orderdb.model.Product;
import de.neuefische.cgn222orderdb.repo.OrderRepo;
import de.neuefische.cgn222orderdb.repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Order orderProducts(List<String> productIds, String id) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        return orderRepo.addOrder(new Order(id, productsToOrder));
    }

    private Product getProduct(String productId) {
        return productRepo.getProduct(productId);
    }

    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }
}
