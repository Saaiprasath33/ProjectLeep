package com.logisticsportal.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "pickup_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PickupRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User requester;

    @Column(length = 255)
    private String itemDescription;

    @Column(length = 255)
    private String pickupAddress;

    @Column(length = 255)
    private String dropAddress;

    @Column(length = 20)
    private String requestStatus; // Pending / Assigned / Completed / Cancelled

    private OffsetDateTime requestedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    private OffsetDateTime assignedAt;
    private OffsetDateTime completedAt;

    @Column(length = 255)
    private String remarks;

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRequestStatus(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getRemarks() {
		// TODO Auto-generated method stub
		return null;
	}
}
