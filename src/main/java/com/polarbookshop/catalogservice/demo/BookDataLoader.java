package com.polarbookshop.catalogservice.demo;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Component
@Profile("testdata")
@RequiredArgsConstructor
public class BookDataLoader {

	private final BookRepository bookRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void loadBookTestData() {
		bookRepository.deleteAll();
		
		val book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
		val book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
		bookRepository.saveAll(List.of(book1, book2));
	}
}
