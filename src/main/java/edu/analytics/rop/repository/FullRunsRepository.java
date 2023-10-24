package edu.analytics.rop.repository;

import edu.analytics.rop.entities.FullRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullRunsRepository extends JpaRepository<FullRun, Long> {
}
