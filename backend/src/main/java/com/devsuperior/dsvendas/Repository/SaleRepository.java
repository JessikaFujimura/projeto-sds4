package com.devsuperior.dsvendas.Repository;

import com.devsuperior.dsvendas.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
