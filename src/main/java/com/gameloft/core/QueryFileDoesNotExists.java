package com.gameloft.core;

public class QueryFileDoesNotExists extends Exception {

    public QueryFileDoesNotExists(String fileName) {
        super("Query file: " + fileName + " doesn't exists");
    }
}
