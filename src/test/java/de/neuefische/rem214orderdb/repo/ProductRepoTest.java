package de.neuefische.rem214orderdb.repo;

import de.neuefische.rem214orderdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    @DisplayName("listProducts should return all available products")
    public void testListProducts(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);
        //WHEN
        List<Product> actual = productRepo.listProducts();

        //THEN
        assertEquals(products, actual);
    }

    @Test
    @DisplayName("getProduct should return product with matching id")
    public void testGetProductWithExistingId(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);

        //WHEN
        Product actual = productRepo.getProduct("2");

        //THEN
        assertEquals(new Product("2", "guitar"), actual);

    }

    @Test
    @DisplayName("getProduct should return product with matching id")
    public void testGetProductWithNonExistingId(){
        //GIVEN
        List<Product> products = List.of(
                new Product("1", "piano"),
                new Product("2", "guitar"),
                new Product("3", "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);

        //WHEN & THEN
        try {
            productRepo.getProduct("4");
            fail();
        }
        catch (NoSuchElementException e) {
            assertEquals("Prduct with id: 4 not found!", e.getMessage());
        }
    }

}
