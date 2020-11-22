package de.bockhorn.codechallenge.model;

import java.util.HashMap;

/**
 * Model is virtually the same as HashMap<String, String>.
 * But for compliance with MVC and storing in database a very own class.
 */
public class Product extends HashMap<String, String> {

    public Product(String name, int amount) {
        this.put("name", name);
        this.put("amount", String.valueOf(amount));
    }
}
