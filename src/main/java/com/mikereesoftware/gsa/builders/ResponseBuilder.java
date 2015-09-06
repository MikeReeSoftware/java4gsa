package com.mikereesoftware.gsa.builders;

import com.mikereesoftware.gsa.response.Response;
import com.mikereesoftware.gsa.sax.ResponseHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * Created by mike on 9/1/15.
 */
public class ResponseBuilder {
    public static Response Parse(InputStream is) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            // Remove DTD Requirement
            reader.setEntityResolver((publicId, systemId) -> new InputSource(new StringReader("")));
            ResponseHandler handler = new ResponseHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(is));
            return handler.getResponse();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
