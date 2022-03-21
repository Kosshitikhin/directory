package com.kosshitikhin.directory.entry.dto;

import javax.validation.constraints.NotNull;

public class EntryRequest {

    @NotNull
    private String name;
    @NotNull
    private String shortName;

    public EntryRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
