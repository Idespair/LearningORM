package br.com.Idespair.MoviesAPI;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends MongoRepository<Reviews, ObjectId> {
}
