package com.kosshitikhin.directory.entry;

import com.kosshitikhin.directory.entry.dto.EntryDto;
import com.kosshitikhin.directory.entry.dto.EntryRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("entries")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    public List<EntryDto> getAllEntries() {
        return entryService.getAllEntries();
    }

    @GetMapping("{entryId}")
    public EntryDto getEntryById(@PathVariable Integer entryId) {
        return entryService.getEntryById(entryId);
    }

    @GetMapping("search")
    public List<EntryDto> getEntryByName(@RequestParam String searchParam) {
        return entryService.getEntryByName(searchParam);
    }

    @PostMapping
    public void addNewEntry(@RequestBody @Valid EntryRequest entryRequest) {
        entryService.addNewEntry(entryRequest);
    }

    @PutMapping("{entryId}")
    public void editEntry(@PathVariable Integer entryId,
                          @RequestBody @Valid EntryRequest entryRequest) {
        entryService.editEntry(entryId, entryRequest);
    }

    @DeleteMapping("{entryId}")
    public void deleteEntry(@PathVariable Integer entryId) {
        entryService.deleteEntry(entryId);
    }
}
