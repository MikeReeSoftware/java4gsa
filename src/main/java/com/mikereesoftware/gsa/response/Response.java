package com.mikereesoftware.gsa.response;

import com.mikereesoftware.gsa.sax.ISaxable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mike on 8/26/15.
 */
public class Response implements ISaxable {
    private ResponseHeader responseHeader = new ResponseHeader();
    private List<ResponseDocument> documents = new ArrayList<ResponseDocument>();

    public void parse(String gsaResponseString) {

    }

    public void process(String key, String data) {

    }

    public void addMetadata(String key, String value) {
        throw new IllegalArgumentException("This method should not be able to be called");
    }

    public ResponseHeader getHeaders() {
        return responseHeader;
    }

    public void addDocument(ResponseDocument document) {
        documents.add(document);
    }

    public Collection getDocuments() {
        return documents;
    }
}
