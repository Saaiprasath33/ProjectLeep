package com.logisticsportal.service;

import com.logisticsportal.model.PickupLog;
import com.logisticsportal.repository.PickupLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PickupLogService {
    private final PickupLogRepository repo = null;

    public List<PickupLog> findByRequestId(Long requestId) {
        return repo.findByRequestRequestId(requestId);
    }
}
