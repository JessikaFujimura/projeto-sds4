package com.devsuperior.dsvendas.Controllers;

import com.devsuperior.dsvendas.Domain.SaleDto;
import com.devsuperior.dsvendas.Domain.SaleSuccessDto;
import com.devsuperior.dsvendas.Domain.SaleSumDto;
import com.devsuperior.dsvendas.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<SaleDto>> getAll(Pageable pageable){
        Page<SaleDto> list = saleService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/amount-by-seller")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SaleSumDto>> getAmountGroupedBySeller(){
        List<SaleSumDto> list = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SaleSuccessDto>> getSuccessGroupedBySeller(){
        List<SaleSuccessDto> list = saleService.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}
