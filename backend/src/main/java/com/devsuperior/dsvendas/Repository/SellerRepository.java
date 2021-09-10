package com.devsuperior.dsvendas.Repository;

import com.devsuperior.dsvendas.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
