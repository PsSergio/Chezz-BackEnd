package com.api.chezz.repositories;

import com.api.chezz.models.CodeValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<CodeValidation, Long> {
}
