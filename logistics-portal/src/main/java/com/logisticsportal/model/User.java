package com.logisticsportal.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String contact;

    @Column(length = 20)
    private String role; // USER / ADMIN / STAFF

    private OffsetDateTime joinDate;

	public void setJoinDate(OffsetDateTime now) {
		// TODO Auto-generated method stub
		
	}
}
