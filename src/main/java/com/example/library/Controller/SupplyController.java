package com.example.library.Controller;

import com.example.library.ApiResponse;
import com.example.library.DTO.SupplyCreateDTO;
import com.example.library.DTO.SupplyUpdateDTO;
import com.example.library.Model.Supply;
import com.example.library.Service.SupplyService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplies")
@Slf4j
public class SupplyController {
    @Autowired
    private SupplyService supplyService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addSupply(@Valid @RequestBody SupplyCreateDTO dto){
        Supply supply = supplyService.addSupply(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("SUCESS","New supply created",supply));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateSupply(@PathVariable Long id ,@Valid @RequestBody SupplyUpdateDTO dto){
        if(dto.getId()!=null || dto.getQuantity()!=null){
            log.warn("Client sent ID or Quantity feild");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(new ApiResponse<>("Fail","ID or Quantity feild is not permitted",null));
        }
        Supply supply = supplyService.updateSupply(id,dto);
        return  ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("SUCESS","New supply created",supply));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteSupply(@PathVariable Long id){
        Supply supply= supplyService.deleteSupply(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse<>("SUCESS","Supply deleted",supply));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> findByName(@RequestParam String keyword){
        List<Supply> supplies = supplyService.findByName(keyword);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("SUCESS","Supply deleted",supplies));
    }
}
