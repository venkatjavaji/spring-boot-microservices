package org.vijava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vijava.entity.ProductAutoTab;

@Repository
public interface ProductRepository extends JpaRepository<ProductAutoTab,Long> {
}
