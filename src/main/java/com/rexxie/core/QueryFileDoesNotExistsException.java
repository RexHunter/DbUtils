package com.rexxie.core;

public class QueryFileDoesNotExistsException extends Exception {

    public QueryFileDoesNotExistsException(String fileName) {
        super("Query file: " + fileName + " doesn't exists");
    }
}
