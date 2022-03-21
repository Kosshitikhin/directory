package com.kosshitikhin.directory.entry;

import com.kosshitikhin.directory.entry.dto.EntryDto;
import com.kosshitikhin.directory.entry.dto.EntryRequest;
import com.kosshitikhin.directory.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {

    private final EntryMapper entryMapper;

    private final Logger logger = LogManager.getLogger();

    public EntryService(EntryMapper entryMapper) {
        this.entryMapper = entryMapper;
    }

    public List<EntryDto> getAllEntries() {
        logger.info("Get all entries");
        return entryMapper.findAllEntry().stream()
                .map(EntryDto::new)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "entries", key = "#entryId")
    public EntryDto getEntryById(Integer entryId) {
        logger.info("Get entry with id: {} ", entryId);
        return new EntryDto(entryMapper.findById(entryId).orElseThrow(NotFoundException::entry));
    }

    public List<EntryDto> getEntryByName(String searchParam) {
        return entryMapper.findByName("%" + searchParam + "%").stream()
                .map(EntryDto::new)
                .collect(Collectors.toList());
    }

    @CachePut(value = "entries", key = "#entryRequest.name")
    public void addNewEntry(EntryRequest entryRequest) {
        logger.info("Add new entry with name \"{}\" and shortName \"{}\"", entryRequest.getName(), entryRequest.getShortName());
        entryMapper.insertEntry(entryRequest.getName(), entryRequest.getShortName());
    }

    @CachePut(value = "entries", key = "#entryRequest.name")
    public void editEntry(Integer entryId, EntryRequest entryRequest) {
        logger.info("Edit entry with id: {} ", entryId);
        entryMapper.updateEntry(entryId, entryRequest.getName(), entryRequest.getShortName());
    }

    @CacheEvict(value = "entries", key = "#entryId")
    public void deleteEntry(Integer entryId) {
        logger.info("Delete entry with id: {} ", entryId);
        entryMapper.deleteEntryById(entryId);
    }
}
