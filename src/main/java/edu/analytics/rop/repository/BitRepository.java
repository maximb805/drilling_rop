package edu.analytics.rop.repository;

import edu.analytics.rop.domain.Bit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitRepository extends JpaRepository<Bit, Long> {
}