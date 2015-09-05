package com.mikereesoftware.gsa.sax;

import com.mikereesoftware.gsa.response.Response;
import com.mikereesoftware.gsa.response.ResponseDocument;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by mike on 9/1/15.
 */
public class ResponseHandler extends DefaultHandler {
    boolean inHeader = true;
    private final Response response = new Response();
    private ISaxable current = response.getHeaders();
    private String[] params = new String[3];
    private String pendingKey = null;

    @Override
    public void startElement(String uri, String localName,String qName,
                             Attributes attributes) throws SAXException {


        if (inHeader) {
            if (qName.equals("TM") || qName.equals("Q")) {
                pendingKey = qName;
            } else if (qName.equals("PARAM")) {
                setParams(attributes);
                response.getHeaders().setParam(params);
            } else if (qName.equals("RES")) {
                setParams(attributes);
                response.getHeaders().setPage(params);
            } else if (qName.equals("R")) {
                inHeader = false;
                newDoc();
            }
        } else {
            if (qName.equals("R")) {
                newDoc();
            } else if (qName.equals("MT")) {
                setParams(attributes);
                current.addMetadata(params[0], params[1]);
            }
        }
    }

    private void setParams(Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            params[i] = attributes.getValue(i);
        }
    }

    private void newDoc() {
        ResponseDocument doc = new ResponseDocument();
        response.addDocument(doc);
        current = doc;
    }

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        pendingKey = null;
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (pendingKey != null)
            current.process(pendingKey, new String(ch, start, length));
    }

    public Response getResponse() {
        return response;
    }


}
