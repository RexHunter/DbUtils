package com.rexxie.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QueryLoader {
    private static Logger LOGGER = LogManager.getLogger(QueryLoader.class);

    private static String SQL = ".sql";
    private String destinationFolder;

    public QueryLoader(String destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    public QueryLoader() {
    }

    /**
     * Load query from resource file
     */
    public String loadQueryFromResourceFile(String sourcePath) throws QueryFileDoesNotExistsException {
        sourcePath = destinationFolder + sourcePath + SQL;
        File file = new File(getClass().getClassLoader().getResource(sourcePath).getFile());
        BufferedReader reader = null;
        String query = "";

        if(!file.exists())
            throw new QueryFileDoesNotExistsException(sourcePath);

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                query += " " + line;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return query;
    }
}