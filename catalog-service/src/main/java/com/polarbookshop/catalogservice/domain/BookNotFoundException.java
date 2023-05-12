package com.polarbookshop.catalogservice.domain;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 123991954805591602L;

	public BookNotFoundException(String isbn) {
		super("The book with ISBN " + isbn + " was not found.");
	}
}
