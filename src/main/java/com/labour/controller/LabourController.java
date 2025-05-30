package com.labour.controller;

import com.labour.models.Labour;
import com.labour.service.LabourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/labour")
public class LabourController {

    @Autowired
    private LabourService labourService;

    @PostMapping("/add")
    public ResponseEntity<String> addLabour(@RequestBody Labour labour) {
        Labour savedLabour = labourService.addLabour(labour);
        return ResponseEntity.ok("Labour added successfully: " + savedLabour.getName());
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Labour>> getLaboursByLocation(@PathVariable String location) {
        List<Labour> labours = labourService.getLabourByLocation(location);
        return ResponseEntity.ok(labours);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLabour(@PathVariable Long id, @RequestBody Labour updated) {
        Optional<Labour> labourOpt = labourService.getLabourById(id);
        if (labourOpt.isEmpty()) return ResponseEntity.notFound().build();

        Labour labour = labourOpt.get();
        labour.setSkill(updated.getSkill());
        labour.setLocation(updated.getLocation());
        labour.setHourlyRate(updated.getHourlyRate());

        labourService.addLabour(labour);
        return ResponseEntity.ok("Updated successfully");
    }

}
