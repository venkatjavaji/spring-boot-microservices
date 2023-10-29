package org.vijava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vijava.entity.SampleIdentityTab;

public interface SampleRepository extends JpaRepository<SampleIdentityTab,Long> {
}
