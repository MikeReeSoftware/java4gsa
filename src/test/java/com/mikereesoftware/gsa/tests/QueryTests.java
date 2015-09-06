package com.mikereesoftware.gsa.tests;

import com.mikereesoftware.gsa.GsaQuery;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mike on 9/5/15.
 */
public class QueryTests {
    @Test
    public void testBasicQuery() throws Exception{
        GsaQuery query = new GsaQuery().setQuery("google").setGetFields("*");
        assertTrue("Query: " + query.toString(), query.toString().equals(""));
    }
}
