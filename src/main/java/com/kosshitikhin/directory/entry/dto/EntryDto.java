package com.kosshitikhin.directory.entry.dto;

import com.kosshitikhin.directory.entry.Entry;

public class EntryDto {

    private Integer id;
    private String name;
    private String shortName;

    public EntryDto() {
    }

    public EntryDto(Entry entry) {
        this.id = entry.getId();
        this.name = entry.getName();
        this.shortName = entry.getShortName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
