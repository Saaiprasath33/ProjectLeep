package com.logisticsportal.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusDto {
    private String status; // Completed / Cancelled
    private String remarks;
	public String getRemarks() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
