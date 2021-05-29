package com.microservice.book.repository;

import com.microservice.book.domain.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
	
}
