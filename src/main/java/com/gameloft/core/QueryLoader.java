package com.gameloft.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QueryLoader {

    /**
     * Load query from resource file
     */
    public String loadQuery(String sourcePath) {
        sourcePath = "sql/" + sourcePath + ".sql";
        File file = new File(getClass().getClassLoader().getResource(sourcePath).getFile());
        BufferedReader reader = null;
        String query = "";

        try {
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                query += " " + line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return query;
    }
}