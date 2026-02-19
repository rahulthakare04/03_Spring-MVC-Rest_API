package com.example.springboottwebutorial.controllers;

import com.example.springboottwebutorial.Exceptions.DepartmentNotFoundException;
import com.example.springboottwebutorial.Exceptions.ResourceNotFoundException;
import com.example.springboottwebutorial.dto.DepartmentDTO;
import com.example.springboottwebutorial.dto.EmployeeDTO;
import com.example.springboottwebutorial.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "department")
public class DepartmentController {

    private  final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> GetDepartmentById(@PathVariable(name = "departmentId") Long departmentId){
        Optional<DepartmentDTO> departmentDTO= departmentService.GetDepartmentById(departmentId);
        return departmentDTO.map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1)).orElseThrow(()->new DepartmentNotFoundException("Department not found of this id"));

    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> departmentDTOS= departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentDTOS);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        DepartmentDTO savedepartmentDTO=departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedepartmentDTO, HttpStatus.CREATED);


    }

    @PutMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmrnt(@RequestBody @Valid DepartmentDTO inputDepartment,@PathVariable Long departmentId){
        DepartmentDTO departmentDTO=departmentService.updateDepartment(inputDepartment,departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<Boolean> DepartmentDelete(@PathVariable  Long departmentId){
        boolean gotDelete=departmentService.departmentDelete(departmentId);
        if(gotDelete) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }



}
