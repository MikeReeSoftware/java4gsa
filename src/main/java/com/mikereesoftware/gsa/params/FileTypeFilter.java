package com.mikereesoftware.gsa.params;

/**
 * Created by mike on 8/26/15.
 */
public class FileTypeFilter {
    private final boolean include;
    private final String fileType;

    public FileTypeFilter(String fileType) {
        this.include = true;
        this.fileType = fileType;
    }

    public FileTypeFilter(boolean include, String fileType) {
        this.include = include;
        this.fileType = fileType;
    }
}
