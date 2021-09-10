package com.devsuperior.dsvendas.Repository;

import com.devsuperior.dsvendas.Domain.SaleSuccessDto;
import com.devsuperior.dsvendas.Domain.SaleSumDto;
import com.devsuperior.dsvendas.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT NEW com.devsuperior.dsvendas.Domain.SaleSumDto(obj.seller, SUM(obj.amount)) FROM Sale As obj GROUP BY obj.seller")
    List<SaleSumDto> amountGroupedBySeller();

    @Query("SELECT NEW com.devsuperior.dsvendas.Domain.SaleSuccessDto(obj.seller, SUM(obj.visited), SUM(obj.deals)) FROM Sale As obj GROUP BY obj.seller")
    List<SaleSuccessDto> successGroupedBySeller();

}
