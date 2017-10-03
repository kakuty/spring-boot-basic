package com.learn.demo.boostrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.learn.demo.model.Author;
import com.learn.demo.model.Book;
import com.learn.demo.model.Publisher;
import com.learn.demo.repositories.AuthorRepository;
import com.learn.demo.repositories.BookRepository;
import com.learn.demo.repositories.PublisherRepository;

@Component
@EnableJpaRepositories("com.learn.demo.repositories")
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authoRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	

	public DevBootstrap(AuthorRepository authoRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authoRepository = authoRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher("foo", "somewhere");
		this.publisherRepository.save(publisher);
		
		// Eric
		Author eric = new Author("Eric", "Evan");
		Book ddd = new Book("Domain Driven Developemnt", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authoRepository.save(eric);
		bookRepository.save(ddd);
	}
}
