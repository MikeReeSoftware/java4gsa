package com.mikereesoftware.gsa.params;

/**
 * Created by mike on 8/26/15.
 */
public class CustomParameter {
    private final String key;
    private final String value;

    public CustomParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
