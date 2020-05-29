package com.qa.repo;

import com.qa.domain.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long> {

    BookingInfo findByBookingInfoId(Long bookingInfoId);

}
