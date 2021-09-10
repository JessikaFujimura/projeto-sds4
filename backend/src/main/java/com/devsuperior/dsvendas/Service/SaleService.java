package com.devsuperior.dsvendas.Service;

import com.devsuperior.dsvendas.Domain.SaleDto;
import com.devsuperior.dsvendas.Domain.SaleSuccessDto;
import com.devsuperior.dsvendas.Domain.SaleSumDto;
import com.devsuperior.dsvendas.Entity.Sale;
import com.devsuperior.dsvendas.Repository.SaleRepository;
import com.devsuperior.dsvendas.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDto> findAll(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(i -> new SaleDto(i));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDto> amountGroupedBySeller(){
       return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDto> successGroupedBySeller(){
        return saleRepository.successGroupedBySeller();
    }
}
