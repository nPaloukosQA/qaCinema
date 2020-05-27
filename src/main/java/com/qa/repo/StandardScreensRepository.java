package com.qa.repo;

import com.qa.domain.StandardScreen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardScreensRepository extends JpaRepository<StandardScreen, Long> {

    StandardScreen findByStandardScreenBookingId(Long standardScreenId);

}
