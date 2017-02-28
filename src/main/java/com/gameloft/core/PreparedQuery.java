package com.gameloft.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class PreparedQuery {
    private String query;
    private Connection connection;

    public PreparedQuery(Connection connection, String query) {
        this.query = query;
        this.connection = connection;
    }

    /**
     * Set string value to query
     */
    public void setString(String key, String value) {
        value = "'" + value + "'";
        setObject(key, value);
    }

    /**
     * Set integer value to string query
     */
    public void setInt(String key, Integer id) {
        setObject(key, id);
    }

    /**
     * Set integer array value to string query
     */
    public void setIntArray(String key, Integer[] values) {
        setObject(key, Arrays.toString(values).replace("[", "").replace("]", ""));
    }

    /**
     * Set string array to query
     */
    public void setStringArray(String key, String[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = "'" + values[i] + "'";
        }
        setObject(key, Arrays.toString(values).replace("[", "").replace("]", ""));
    }

    /**
     * Set object value to query
     */
    public void setObject(String key, Object object) {
        this.query = this.query.replace(key, object.toString());
    }

    /**
     * Generate PreparedStatement by query
     */
    public PreparedStatement execute() throws SQLException {
        return connection.prepareStatement(this.query);
    }
}