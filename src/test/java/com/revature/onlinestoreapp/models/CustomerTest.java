package com.revature.onlinestoreapp.models;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    Customer customerTest = new Customer();

    @Test
    public void checkEmail(){

        customerTest.setEmail("testemail@gmail.com");
        assertEquals("testemail@gmail.com", customerTest.getEmail());

    }

    @Test
    public void checkFirstName(){

        customerTest.setFirstName("Jim");
        assertEquals("Jim", customerTest.getFirstName());

    }

    @Test
    public void checkLastName(){

        customerTest.setLastName("Halpert");
        assertEquals("Halpert", customerTest.getLastName());

    }

    @Test
    public void createCustomerTest(){

        Customer newCustomer =
                new Customer("Mac","Miller", "music@email.com", "macsPassword");

        assertEquals(newCustomer.getPassword(), "macsPassword");

    }


}
