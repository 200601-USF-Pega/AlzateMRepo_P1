package com.revature.onlinestoreapp.models;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class ProductTest {

    Product productTest = new Product();

    @Test
    public void checkPrice(){

        productTest.setPrice(500);
        assertEquals(500, productTest.getPrice());

    }

    @Test
    public void checkDescription(){

        productTest.setDescription("Great instrument for music");
        assertEquals("Great instrument for music", productTest.getDescription());

    }

    @Test
    public void createProductCheck(){

        Product newProduct =
                new Product("Guitar", 700, "Hollow Body");

        assertEquals(newProduct.getName(), "Guitar");

    }
}
