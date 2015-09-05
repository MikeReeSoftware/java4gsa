package com.mikereesoftware.gsa.response;

import com.mikereesoftware.gsa.sax.ISaxable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 9/4/15.
 */
public class ResponseHeader implements ISaxable {
    private double gsaElapsTime;
    private String query;
    private List<QueryResponseParameters> queryResponseParameterses = new ArrayList<QueryResponseParameters>();
    private int pageStart;
    private int pageEnd;
    private int totalResults;

    public void process(String key, String data) {
        if (key.equals("TM"))
            gsaElapsTime = Double.parseDouble(data);
        else if (key.equals("Q"))
            query = data;
        else if (key.equals("M"))
            totalResults = Integer.parseInt(data);
    }

    public void addMetadata(String key, String value) {
        throw new IllegalArgumentException("This method should not be able to be called");
    }

    public void setParam(String... params) {
        queryResponseParameterses.add(new QueryResponseParameters(params[0], params[1], params[2]));
    }

    public void setPage(String[] params) {
        pageStart = Integer.parseInt(params[0]);
        pageEnd = Integer.parseInt(params[1]);
    }
}
