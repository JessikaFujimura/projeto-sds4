package com.devsuperior.dsvendas.Controllers;

import com.devsuperior.dsvendas.Domain.SellerDto;
import com.devsuperior.dsvendas.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SellerDto>> getAll(){
        List<SellerDto> list = sellerService.findAll();
        return ResponseEntity.ok(list);
    }


}
