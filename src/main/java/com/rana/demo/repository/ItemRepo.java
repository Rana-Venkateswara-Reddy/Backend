package com.rana.demo.repository;

import com.rana.demo.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item,String> {
}
