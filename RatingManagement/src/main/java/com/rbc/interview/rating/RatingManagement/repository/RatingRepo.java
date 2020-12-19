package com.rbc.interview.rating.RatingManagement.repository;

import com.rbc.interview.rating.RatingManagement.models.Rating;
import com.rbc.interview.rating.RatingManagement.models.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating, RatingId> {

}
