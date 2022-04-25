package edu.analytics.rop.repository;

import edu.analytics.rop.domain.Well;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WellRepository extends JpaRepository<Well, Long> {
}
