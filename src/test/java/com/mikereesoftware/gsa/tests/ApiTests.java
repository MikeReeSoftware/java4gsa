package com.mikereesoftware.gsa.tests;

import com.mikereesoftware.gsa.response.Response;
import com.mikereesoftware.gsa.builders.ResponseBuilder;
import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by mike on 8/26/15.
 */
public class ApiTests {

    @Test
    public void testParseResponse() throws Exception{
        File f  = new File("sample_response.xml");
        FileInputStream is = new FileInputStream(f);
        Response response = ResponseBuilder.Parse(is);

        Assert.assertTrue(response.getDocuments().size() == 10);
    }
}
