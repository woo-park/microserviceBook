package com.microservice.book.component;

public class BookingException extends RuntimeException  {
	
	public BookingException(String message){
		super(message);
	}
}
