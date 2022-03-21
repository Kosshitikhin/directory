package com.kosshitikhin.directory.entry;

import java.util.Objects;

public class Entry {

    private Integer id;
    private String name;
    private String shortName;

    public Entry() {
    }

    public Entry(Integer id) {
        this.id = id;
    }

    public Entry(String name) {
        this.name = name;
    }

    public Entry(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Entry(Integer id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(id, entry.id) &&
                Objects.equals(name, entry.name) &&
                Objects.equals(shortName, entry.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }
}
