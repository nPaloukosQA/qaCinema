package com.qa.rest;

import com.qa.domain.StandardScreen;
import com.qa.dto.StandardScreenDTO;
import com.qa.service.StandardScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StandardScreenController {

    private final StandardScreenService service;

    @Autowired
    public StandardScreenController(StandardScreenService service) {
        this.service = service;
    }

    @PostMapping("/createStandardScreen")
    public ResponseEntity<StandardScreenDTO> createStandardScreen(@RequestBody StandardScreen standardScreen) {
        return new ResponseEntity<StandardScreenDTO>(this.service.createStandardScreen(standardScreen), HttpStatus.CREATED);
    }

    @GetMapping("/getAllStandardScreens")
    public ResponseEntity<List<StandardScreenDTO>> getAllStandardScreens() {
        return ResponseEntity.ok(this.service.readStandardScreens());
    }

    @GetMapping("/getStandardScreenById/{standardScreenId}")
    public ResponseEntity<StandardScreenDTO> getStandardScreenById(@PathVariable Long standardScreenId) {
        return ResponseEntity.ok(this.service.getStandardScreenById(standardScreenId));
    }

    @PutMapping("/updateStandardScreen/{standardScreenId}")
    public ResponseEntity<StandardScreenDTO> updateStandardScreen(@PathVariable Long standardScreenId, @RequestBody StandardScreen standardScreen){
        return ResponseEntity.ok(this.service.updateStandardScreen(standardScreenId, standardScreen));
    }

    @DeleteMapping("/deleteStandardScreen/{standardScreenId}")
    public ResponseEntity<?> deleteStandardScreen(@PathVariable Long standardScreenId){
        return this.service.deleteStandardScreen(standardScreenId)
        ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }
}