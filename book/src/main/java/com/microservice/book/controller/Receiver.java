package com.microservice.book.controller;


import com.microservice.book.component.BookingComponent;
import com.microservice.book.component.BookingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;



@EnableBinding(BookingSink.class)
@Component
public class Receiver {

	@Autowired
	BookingComponent bookingComponent;


	public Receiver(){

	}

	/**
	 public Receiver(BookingComponent bookingComponent){
	 this.bookingComponent = bookingComponent;
	 }

	 @RabbitListener(queues = "CheckINQ")
	 public void processMessage(long bookingID ) {
	 System.out.println("receiver processing message -> bookingID:" + bookingID);
	 bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
	 }
	 **/
	@ServiceActivator(inputChannel = BookingSink.CHECKINQ)
	public void accept(long bookingID){
		bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
	}

}

interface BookingSink {
	public static String CHECKINQ="checkInQ";
	@Input("checkInQ")
	public MessageChannel checkInQ();
}