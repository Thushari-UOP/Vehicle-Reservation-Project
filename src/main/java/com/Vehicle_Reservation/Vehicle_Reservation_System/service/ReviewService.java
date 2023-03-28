package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import com.Vehicle_Reservation.Vehicle_Reservation_System.dto.ReviewDto;
import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.Review;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ReservationRepository;
import com.Vehicle_Reservation.Vehicle_Reservation_System.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void addReview(ReviewDto reviewDto){
        reviewRepository.save(modelMapper.map(reviewDto, Review.class));
    }

//    public boolean deleteReview(Integer reservationId){
//        reviewRepository.delete(modelMapper.map(reviewDto,Review.class));
//        return true;
//    }

    public ReviewDto getReviewByReservationId(Integer reviewId){
        Review review = reviewRepository.getReferenceById(reviewId);
        return modelMapper.map(review,ReviewDto.class);
    }
}
