package com.br.Idespair.MoviesAPIWithSQL.repository;

import com.br.Idespair.MoviesAPIWithSQL.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review, Long> {
}
