package com.microservice.book.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class BookingRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
    
    private String flightNumber;
    private String origin;
    private String destination;
    private String flightDate;
    private Date bookingDate;
    private String fare;
    private String status;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="bookingRecord")
    Set<Passenger> passengers;

	public BookingRecord() {
	}    
    
	public BookingRecord(String flightNumber, String from, String to,
                         String flightDate, Date bookingDate, String fare) {
		this.flightNumber = flightNumber;
		this.origin = from;
		this.destination = to;
		this.flightDate = flightDate;
		this.bookingDate = bookingDate;
		this.fare = fare;
		this.status = status;
	}


	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "BookingRecord [id=" + id + ", flightNumber=" + flightNumber + ", from=" + origin + ", to=" + destination
				+ ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", passengers=" + passengers
				+ "]";
	}
    
    
    
}
