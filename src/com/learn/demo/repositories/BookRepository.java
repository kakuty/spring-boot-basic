package com.learn.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.demo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
