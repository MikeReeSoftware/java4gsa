package com.mikereesoftware.gsa;

import com.mikereesoftware.gsa.response.Response;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Created by mike on 8/26/15.
 */
public class Client {
    private final String address;

    public Client(String address) {
        this.address = address;
    }

    public Response execute(Query query) {
        Response response = new Response();
        HttpMethod method = null;
        try {
            method = new GetMethod(query.toString());
            response.parse(method.getResponseBodyAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (method != null)
                method.releaseConnection();
        }

        return response;
    }
}
