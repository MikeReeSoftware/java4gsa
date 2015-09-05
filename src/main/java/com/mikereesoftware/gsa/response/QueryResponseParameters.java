package com.mikereesoftware.gsa.response;

/**
 * Created by mike on 9/4/15.
 */
public class QueryResponseParameters {
    private final String name, value, original_value;

    public QueryResponseParameters(String name, String value, String original_value) {
        this.name = name;
        this.value = value;
        this.original_value = original_value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getOriginalValue() {
        return original_value;
    }
}
