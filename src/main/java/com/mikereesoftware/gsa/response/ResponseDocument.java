package com.mikereesoftware.gsa.response;

import com.mikereesoftware.gsa.sax.ISaxable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mike on 9/4/15.
 */
public class ResponseDocument implements ISaxable {
    private String url;
    private String title;
    private int rank;
    private String source;
    private String summary;
    private Map<String, String> metadata = new HashMap<String, String>();

    public void process(String key, String data) {
        if (key.equals("U"))
            url = data;
        else if (key.equals("T"))
            title = data;
        else if (key.equals("RK"))
            rank = Integer.parseInt(data);
        else if (key.equals("ENT_SOURCE"))
            source = data;
        else if (key.equals("S"))
            summary = data;
    }

    public void addMetadata(String key, String value) {
        metadata.put(key, value);
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
}
