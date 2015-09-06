package com.mikereesoftware.gsa;

import com.mikereesoftware.gsa.builders.ResponseBuilder;
import com.mikereesoftware.gsa.response.Response;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.InputStream;

/**
 * Created by mike on 8/26/15.
 */
public class GsaClient {
    private final HttpClient client;
    private final String address;

    public GsaClient(String address) {
        this.address = address;
        client = new HttpClient();
    }

    public Response execute(GsaQuery query) {
        Response response = null;
        HttpMethod method = null;
        try {
            System.out.println(this.address + "search" + query.toString());
            method = new GetMethod(this.address + "search" + query.toString());
            client.executeMethod(method);
            try (InputStream is = method.getResponseBodyAsStream()) {
                response = ResponseBuilder.Parse(is);
            }
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
