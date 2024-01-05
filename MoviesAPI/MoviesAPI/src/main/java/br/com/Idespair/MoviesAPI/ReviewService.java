package br.com.Idespair.MoviesAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private IReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews createReview(String reviewBody, String imdbId){

        Reviews reviews =  reviewRepository.insert(new Reviews(reviewBody, LocalDateTime.now(), LocalDateTime.now()));



    mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("reviews").value(reviews))
                    .first();

    return reviews;
    }

}
