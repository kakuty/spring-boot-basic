package com.learn.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.demo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
