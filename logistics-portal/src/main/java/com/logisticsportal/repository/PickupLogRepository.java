package com.logisticsportal.repository;

import com.logisticsportal.model.PickupLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PickupLogRepository extends JpaRepository<PickupLog, Long> {
    List<PickupLog> findByRequestRequestId(Long requestId);
}
