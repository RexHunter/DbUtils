package com.rexxie.core;

import java.sql.SQLException;
import java.util.Arrays;

public class QueryEditor {
    private String query;

    public QueryEditor(String query) {
        this.query = query;
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
     * Build query
     */
    public String build() throws SQLException {
        return this.query;
    }
}