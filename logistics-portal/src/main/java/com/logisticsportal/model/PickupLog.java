package com.logisticsportal.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "pickup_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PickupLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    private PickupRequest request;

    @Column(length = 50)
    private String action; // Requested / Assigned / Completed / Cancelled

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performed_by")
    private User performedBy;

    private OffsetDateTime timestamp;

    @Column(length = 255)
    private String remarks;
}
