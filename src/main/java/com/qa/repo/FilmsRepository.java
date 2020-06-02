package com.qa.repo;

import com.qa.domain.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Long> {
    public Optional<Films> findFilmsByTitle(String filmsTitle);
}
