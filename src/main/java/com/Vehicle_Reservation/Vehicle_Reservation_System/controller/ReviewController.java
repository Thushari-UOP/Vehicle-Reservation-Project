package com.Vehicle_Reservation.Vehicle_Reservation_System.controller;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReviewDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Reservation")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review/add")
    public String addReview(@RequestBody ReviewDto reviewDto){
        reviewService.addReview(reviewDto);
        return "Reviewed";
    }
//    @DeleteMapping("/{reservationId}/review/delete")
//    public boolean deleteReview(@RequestBody ReviewDto reviewDto, @PathVariable Integer reservationId){
//        return true;
//    }

    @GetMapping("/{reservationId}/Review")
    public ReviewDto getReviewByReservationId(@PathVariable Integer reservationId){
        return reviewService.getReviewByReservationId(reservationId);
    }
}
