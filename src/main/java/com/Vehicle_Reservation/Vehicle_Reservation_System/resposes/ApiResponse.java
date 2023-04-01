package com.Vehicle_Reservation.Vehicle_Reservation_System.resposes;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ApiResponse {
    private HttpStatus status;
    private String message;
    private boolean success;
    private Object error;
    private Object data;
}
