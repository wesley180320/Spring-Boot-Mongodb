package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
