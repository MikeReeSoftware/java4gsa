package com.mikereesoftware.gsa;

import com.mikereesoftware.gsa.params.*;

import java.util.List;

/**
 * Created by mike on 8/26/15.
 */
public class Query {
    private String query = null;
    private String site = "default_collection"; // TODO: This should be implemented better
    private String frontend = "default_frontend";
    private String client = "default_frontend";

    private List<FileTypeFilter> fileTypeFilters = null;
    private List<CustomParameter> customParameters = null;

    private String as_epq = null; // Phrase query
    private String as_eq = null; // Exclude the terms from the query
    private String as_lq = null; // Shows backlinks. Pages that link to the following url, IE &as_lq=http://myUrl.com/Page
    private String as_sitesearch = null; // Same as the filter "site:www.myUrl.com"
    private String sitesearch = null; // TODO: Figure out how I want to support this...
    private String ulang = null;

    private String partialfields = null; // TODO: This should be implemented better
    private String requiredfields = null; // TODO: This should be implemented better
    private String sort = null; // TODO: This should be implemented better

    // Possibly use params, unsure...
    private String as_filetype = null; // Filter file types.
    private String as_ft = null; // Use as an include / exclude param.
    private String as_oq = null; // OR of all terms, only used for single terms, doesn't seem useful.
    private String as_q = null; // Add's the specified terms to the q param
    private boolean exclude_apps = true;
    private boolean only_apps = false;

    private Access access = Access.ALL;
    private QueryWithinPage as_occt = QueryWithinPage.ANY_PART_OF_PAGE;
    private QueryExpansionPolicy entqr = QueryExpansionPolicy.NONE;
    private MetaQueryExpansionPolicy entqrm = MetaQueryExpansionPolicy.NONE;
    private ResultBiasingPolicy entsp_enum = ResultBiasingPolicy.FRONTEND_DEFAULT;
    private String entsp = null; // Used if ResultBiasingSettings is set to custom
    private ResultFiltering filter = ResultFiltering.SNIPPET_AND_DIRECTORY_FILTERING;
    private List<String> getfields = null; // List of all the fields to get
    private String gsaRequestID = null;
    private String ie = CharacterEncodings.ENGLISH;
    private String oe = CharacterEncodings.UNICODE;
    private int num = 10;
    private int start = 0;
    private int numgm = 3;
    private int tlen = 70;
    private int wc = 200;
    private boolean wc_mc = true;
    private OutputFormat output = OutputFormat.XML;

    private int proxyreload = 0;
    private boolean enableProxyStylesheet = false;
    private boolean enableAccurateResultCount = false;
    private boolean enableSecureEstiamtes = false;

    // TODO: Need to add support for lr, more complex than a simple string.

    // TODO: I don't understand these parameters, will need to update query to support soon as I understand
    /*
    as_dt
    dnavs - Do not believe I would ever want this.
    proxycustom - I don't think I want to add this...
    ud - will want to support this with logic around its being set to ensure it's used correctly.
     */

    public Query setQuery(String query) {
        this.query = query;
        return this;
    }

    public String getFrontend() {
        return frontend;
    }

    public Query setFrontend(String frontend) {
        this.frontend = frontend;
        return this;
    }

    public Query setSiteSearch(String siteSearch) {
        if (siteSearch.isEmpty()) return this;
        if (siteSearch.length() >= 125)
            throw new IllegalArgumentException("Site Search parameter can not exceed 125 characters.");
        this.as_sitesearch = siteSearch;
        return this;
    }

    /**
     * Set Result Biasing Policy
     * Not required for custom, use setCustomResultBiasing(String) instead.
     * @return this
     */
    public Query setRestulBiasingPolicy(ResultBiasingPolicy resultBiasingPolicy) {
        if (resultBiasingPolicy == ResultBiasingPolicy.CUSTOM)
            throw new IllegalArgumentException("Unable to specify custom, use setCustomResultBiasing(String) instead.");
        this.entsp_enum = resultBiasingPolicy;
        return this;
    }

    public Query setCustomResultBiasing(String polictyName) {
        this.entsp = polictyName;
        this.entsp_enum = ResultBiasingPolicy.CUSTOM;
        return this;
    }

    public Query setExcludeApps(boolean excludeApps) {
        this.exclude_apps = excludeApps;
        return this;
    }

    public Query setGsaRequestID(String gsaRequestID) {
        this.gsaRequestID = gsaRequestID;
        return this;
    }

    public Query setResultCount(int num) {
        this.num = num;
        return this;
    }

    public Query setStartOffset(int num) {
        this.start = num;
        return this;
    }

    public Query setKeyMatchCount(int num) {
        if (num < 0 || num > 50)
            throw new IllegalArgumentException("KeyMatch count must be between the values of 0 and 50.");
        this.numgm = num;
        return this;
    }

    public Query setReturnTitleLength(int num) {
        this.tlen = num;
        return this;
    }

    public Query reloadProxy() {
        this.proxyreload = 1;
        return this;
    }

    public Query enableProxyStylesheet(boolean enable) {
        this.enableProxyStylesheet = enable;
        this.output = enable ? OutputFormat.XML_NO_DTD : OutputFormat.XML;
        return this;
    }

    public Query enableAccurateResultCount(boolean enable) {
        this.enableAccurateResultCount = enable;
        return this;
    }

    public Query enableSecureEstimates(boolean enable) {
        this.enableSecureEstiamtes = enable;
        return this;
    }

    public Query setWildcardExpansionLimit(int num) {
        if (num < 0 || num > 1000)
            throw new IllegalArgumentException("Wildcard expansion limit must be between the values of 0 and 1000.");
        this.wc = num;
        return this;
    }

    public Query requireWildcardPrefix(boolean enable) {
        this.wc_mc = !enable;
        return this;
    }
}
