package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
