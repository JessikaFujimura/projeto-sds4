package com.devsuperior.dsvendas.Service;

import com.devsuperior.dsvendas.Domain.SellerDto;
import com.devsuperior.dsvendas.Entity.Seller;
import com.devsuperior.dsvendas.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDto> findAll(){
        List<Seller> result = sellerRepository.findAll();
        return  result.stream().map(i -> new SellerDto(i)).collect(Collectors.toList());
    }
}
