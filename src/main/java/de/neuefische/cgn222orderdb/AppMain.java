package de.neuefische.cgn222orderdb;

import de.neuefische.cgn222orderdb.model.Product;
import de.neuefische.cgn222orderdb.repo.ProductRepo;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        List<Product> products =  new ArrayList<>(List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        ));

        ProductRepo productRepo = new ProductRepo(products);
        
        OrderRepo orderRepo = new OrderRepo();
        
        ShopService shopService = new ShopService(productRepo, orderRepo);

        System.out.println(shopService.listOrders());
        
        shopService.orderProducts(List.of("2", "3"), "35");

        System.out.println(shopService.listOrders());
        
        System.out.println(shopService.getProduct("1"));

    }
}
