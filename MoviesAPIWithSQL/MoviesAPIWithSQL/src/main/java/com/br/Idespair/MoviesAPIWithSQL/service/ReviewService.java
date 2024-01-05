package com.br.Idespair.MoviesAPIWithSQL.service;

import com.br.Idespair.MoviesAPIWithSQL.model.Review;
import com.br.Idespair.MoviesAPIWithSQL.repository.IReviewRepository;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private IReviewRepository reviewRepository;


}
