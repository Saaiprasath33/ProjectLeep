package com.logisticsportal.repository;

import com.logisticsportal.model.PickupRequest;
import com.logisticsportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PickupRequestRepository extends JpaRepository<PickupRequest, Long> {
    List<PickupRequest> findByRequesterUserId(Long userId);
    List<PickupRequest> findByRequestStatus(String status);
}
