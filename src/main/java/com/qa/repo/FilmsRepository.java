package com.qa.repo;

import com.qa.domain.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmsRepository extends JpaRepository<Films, Long> {

}
