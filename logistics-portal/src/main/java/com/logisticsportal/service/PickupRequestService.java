package com.logisticsportal.service;

import com.logisticsportal.model.PickupRequest;
import com.logisticsportal.model.PickupLog;
import com.logisticsportal.model.User;
import com.logisticsportal.repository.PickupRequestRepository;
import com.logisticsportal.repository.PickupLogRepository;
import com.logisticsportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PickupRequestService {
    private final PickupRequestRepository repo = null;
    private final PickupLogRepository logRepo = null;
    private final UserRepository userRepo = null;

    public PickupRequest create(PickupRequest req) {
        req.setRequestStatus("Pending");
        req.setRequestStatus(OffsetDateTime.now());
        PickupRequest saved = repo.save(req);
        log(saved, "Requested", req.getRequester(), req.getRemarks());
        return saved;
    }

    public PickupRequest assign(Long requestId, Long staffId, String remarks) {
        PickupRequest pr = repo.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found: " + requestId));
        if (!"Pending".equalsIgnoreCase(pr.getRequestStatus())) {
            throw new RuntimeException("Only Pending requests can be assigned"); 
        }
        User staff = userRepo.findById(staffId).orElseThrow(() -> new RuntimeException("Staff not found: " + staffId));
        pr.setAssignedTo(staff);
        pr.setAssignedAt(OffsetDateTime.now());
        pr.setRequestStatus("Assigned");
        pr.setRemarks(remarks);
        PickupRequest saved = repo.save(pr);
        log(saved, "Assigned", staff, remarks);
        return saved;
    }

    public PickupRequest updateStatus(Long requestId, String status, User performer, String remarks) {
        PickupRequest pr = repo.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found: " + requestId));
        if ("Completed".equalsIgnoreCase(status)) {
            pr.setCompletedAt(OffsetDateTime.now());
        }
        pr.setRequestStatus(status);
        pr.setRemarks(remarks);
        PickupRequest saved = repo.save(pr);
        log(saved, status, performer, remarks);
        return saved;
    }

    public List<PickupRequest> findByUserId(Long userId) {
        return repo.findByRequesterUserId(userId);
    }

    public PickupRequest findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Request not found: " + id));
    }

    public List<PickupRequest> findByStatus(String status) {
        return repo.findByRequestStatus(status);
    }

    private void log(PickupRequest req, String action, User by, String remarks) {
        PickupLog pl = PickupLog.builder()
                .request(req)
                .action(action)
                .performedBy(by)
                .timestamp(OffsetDateTime.now())
                .remarks(remarks)
                .build();
        logRepo.save(pl);
    }
}
