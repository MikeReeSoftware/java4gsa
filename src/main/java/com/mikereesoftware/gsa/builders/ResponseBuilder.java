package com.mikereesoftware.gsa.builders;

import com.mikereesoftware.gsa.response.Response;
import com.mikereesoftware.gsa.sax.ResponseHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mike on 9/1/15.
 */
public class ResponseBuilder {
    public static Response Parse(InputStream is) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            ResponseHandler handler = new ResponseHandler();
            saxParser.parse(is, handler);
            return handler.getResponse();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
