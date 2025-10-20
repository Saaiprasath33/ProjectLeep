package com.logisticsportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logisticsportal.service.PickupLogService;

@RestController
@RequestMapping("/api/pickuplogs")
public class PickupLogController {

    private final PickupLogService service;

    public PickupLogController(PickupLogService service) {
        this.service = service;
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<?> logsForRequest(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByRequestId(id));
    }
}
