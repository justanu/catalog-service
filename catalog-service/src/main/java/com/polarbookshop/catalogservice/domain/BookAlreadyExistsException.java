package com.polarbookshop.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 4576260798232433111L;

	public BookAlreadyExistsException(String isbn) {
		super("A book with ISBN " + isbn + " already exists.");
	}
}
