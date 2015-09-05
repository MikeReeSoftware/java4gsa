package com.mikereesoftware.gsa.sax;

/**
 * Created by mike on 9/4/15.
 */
public interface ISaxable {
    void process(String key, String data);

    void addMetadata(String key, String value);
}
