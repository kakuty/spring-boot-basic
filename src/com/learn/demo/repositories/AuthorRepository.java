package com.learn.demo.repositories;

import com.learn.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
