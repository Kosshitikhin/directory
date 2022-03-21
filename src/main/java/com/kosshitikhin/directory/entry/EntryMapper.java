package com.kosshitikhin.directory.entry;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EntryMapper {

    @Select("select * from entries order by name")
    List<Entry> findAllEntry();

    @Select("select id, name, shortname from entries " +
            "where id=#{id}" )
    Optional<Entry> findById(@Param("id") Integer id);

    @Select("select id, name, shortname from entries " +
            "where lower(name) like lower(#{searchParam})" +
            "order by name" )
    List<Entry> findByName(@Param("searchParam") String searchParam);

    @Insert("insert into entries(name, shortname) " +
            "values(#{name}, #{shortName})")
    void insertEntry(@Param("name") String name, @Param("shortName") String shortName);

    @Update("update entries " +
            "set name=#{name}, shortname=#{shortName} " +
            "where id=#{id}")
    void updateEntry(@Param("id") Integer id, @Param("name") String name, @Param("shortName") String shortName);

    @Delete("delete from entries where id=#{id}")
    void deleteEntryById(@Param("id") Integer entryId);
}
