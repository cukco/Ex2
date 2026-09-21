package com.example.library.Service;

import com.example.library.DTO.SupplyCreateDTO;
import com.example.library.DTO.SupplyUpdateDTO;
import com.example.library.Exception.ElementNotFound;
import com.example.library.Model.Supply;
import com.example.library.Repository.SupplyRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SupplyService {
    @Autowired
    private SupplyRepo supplyRepo;

    public Supply addSupply(SupplyCreateDTO dto) {
        if(dto.getQuantity()==null){dto.setQuantity(0);}
        Supply supply = new Supply();
        supply.setName(dto.getName());
        supply.setManufacturer(dto.getManufacturer());
        supply.setUnit(dto.getUnit());
        supply.setQuantity(dto.getQuantity());
        supply=supplyRepo.save(supply);
        log.info("New supply created: {} with ID: {}", supply.getName(), supply.getId());
        return supply;
    }

    public Supply updateSupply(Long id,SupplyUpdateDTO dto) {
        Supply supply = supplyRepo.findById(id).orElseThrow(()->new ElementNotFound("Supply not found") ) ;
        supply.setName(dto.getName());
        supply.setManufacturer(dto.getManufacturer());
        supply.setUnit(dto.getUnit());
        supply=supplyRepo.save(supply);
        log.info("Supply updated: {} with ID: {}", supply.getName(), supply.getId());
        return supply;
    }

    public Supply deleteSupply(Long id){
        Supply supply=supplyRepo.findById(id).orElseThrow(()->new ElementNotFound("Supply not found"));
        supply.setDeleted(true);
        log.info("Supply deleted: {} with ID: {}", supply.getName(), supply.getId());
        return  supplyRepo.save(supply);
    }

    public List<Supply> findByName(String name){
        List<Supply> lists=supplyRepo.findByKeyword(name);
        if(lists==null){
            log.info("No Supply matching name: {}",name);
            return new ArrayList<>();
        }else {
            log.info("Supply matching name: {}",name);
            return lists;
        }
    }
}
