package com.logisticsportal.controller;

import com.logisticsportal.service.PickupRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final PickupRequestService service = new PickupRequestService();

    @GetMapping("/pendingrequests")
    public ResponseEntity<?> pending() {
        return ResponseEntity.ok(service.findByStatus("Pending"));
    }

    @GetMapping("/completedrequests")
    public ResponseEntity<?> completed() {
        return ResponseEntity.ok(service.findByStatus("Completed"));
    }
}
