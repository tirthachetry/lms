package com.labour.repository;

import com.labour.models.Labour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabourRepository extends JpaRepository<Labour, Long> {
    List<Labour> findByLocationIgnoreCase(String location);
}

