package com.qa.rest;

import com.qa.domain.DeluxeScreen;
import com.qa.dto.DeluxeScreenDTO;
import com.qa.service.DeluxeScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
public class DeluxeScreenController {

    private final DeluxeScreenService service;

    @Autowired
    public DeluxeScreenController(DeluxeScreenService service) {
        this.service = service;
    }

    @PostMapping("/createDeluxeScreen")
    public ResponseEntity<DeluxeScreenDTO> createDeluxeScreen(@RequestBody DeluxeScreen deluxeScreen) {
        return new ResponseEntity<DeluxeScreenDTO>(this.service.createDeluxeScreen(deluxeScreen), HttpStatus.CREATED);
    }

    @GetMapping("/getAllDeluxeScreens")
    public ResponseEntity<List<DeluxeScreenDTO>> getAllDeluxeScreens() {
        return ResponseEntity.ok(this.service.readDeluxeScreens());
    }

    @GetMapping("/getDeluxeScreenById/{deluxeScreenId}")
    public ResponseEntity<DeluxeScreenDTO> getDeluxeScreenById(@PathVariable Long deluxeScreenId) {
        return ResponseEntity.ok(this.service.getDeluxeScreenById(deluxeScreenId));
    }

    @PostMapping("/updateDeluxeScreen/{deluxeScreenId}")
    public ResponseEntity<DeluxeScreenDTO> updateDeluxeScreen(@PathVariable Long deluxeScreenId, @RequestBody DeluxeScreen deluxeScreen) {
        return ResponseEntity.ok(this.service.updateDeluxeScreen(deluxeScreenId, deluxeScreen));
    }

    @DeleteMapping("/deleteDeluxeScreen/{deluxeScreenId}")
    public ResponseEntity<?> deleteDeluxeScreen(@PathVariable Long deluxeScreenId) {
        return this.service.deleteDeluxeScreen(deluxeScreenId)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.ok(this.service.getDeluxeScreenById(deluxeScreenId));
    }
}
