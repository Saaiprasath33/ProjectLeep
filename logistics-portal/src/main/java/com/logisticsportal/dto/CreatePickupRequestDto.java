package com.logisticsportal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePickupRequestDto {
    private Long userId;
    private String itemDescription;
    private String pickupAddress;
    private String dropAddress;
    private String remarks;
	public Object getPickupAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getItemDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
