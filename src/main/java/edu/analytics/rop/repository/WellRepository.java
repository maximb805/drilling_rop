package edu.analytics.rop.repository;

import edu.analytics.rop.entities.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WellRepository extends JpaRepository<Well, Long> {
}
