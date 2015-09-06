package com.mikereesoftware.gsa.tests;

import com.mikereesoftware.gsa.GsaClient;
import com.mikereesoftware.gsa.GsaQuery;
import com.mikereesoftware.gsa.builders.ResponseBuilder;
import com.mikereesoftware.gsa.response.Response;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Created by mike on 8/26/15.
 */
public class ApiTests {
    @Test
    public void testParseResponse() throws Exception{
        File f  = new File("sample_response.xml");
        FileInputStream is = new FileInputStream(f);
        Response response = ResponseBuilder.Parse(is);

        assertTrue(response.getDocuments().size() == 10);
    }

    @Test
    public void testCallingGSA() throws Exception{
        String server = new String(Files.readAllBytes(Paths.get("sample_response_server.txt")));
        Response response = new GsaClient(server).execute(new GsaQuery()
                .setQuery("google").setGetFields("*"));

        assertTrue(response.getDocuments().size() == 10);
    }
}
