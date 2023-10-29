package org.vijava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vijava.entity.OrderSeqTab;
@Repository
public interface OrderRepository extends JpaRepository<OrderSeqTab,Long> {
}
