package com.qa.repo;

import com.qa.domain.DeluxeScreen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeluxeScreenRepository extends JpaRepository<DeluxeScreen, Long> {

    DeluxeScreen findByDeluxeBookingId(Long deluxeScreenId);
}
