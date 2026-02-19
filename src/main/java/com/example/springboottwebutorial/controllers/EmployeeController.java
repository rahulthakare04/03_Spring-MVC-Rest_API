package com.example.springboottwebutorial.controllers;

import com.example.springboottwebutorial.Exceptions.ResourceNotFoundException;
import com.example.springboottwebutorial.dto.EmployeeDTO;
import com.example.springboottwebutorial.entities.EmployeeEntity;
import com.example.springboottwebutorial.repositories.EmployeeRepository;
import com.example.springboottwebutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //    @GetMapping(path = "/getmessage")
//    public String getMassage(){
//        return "my message is : yjgjhggj";
//    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeesById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO =employeeService.getEmployeesById(id);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElseThrow(() ->new ResourceNotFoundException("Employee not found with id "+id ));

    }



    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam(required = false,name = "inputAge") Integer age ,
                                               @RequestParam(required = false) String name){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO  inputemployee){

        EmployeeDTO savedEmployee= employeeService.createNewEmployee(inputemployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO,@PathVariable (name = "employeeId") Long employeeId){
       return  ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO,employeeId));

    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        boolean gotDeleted= employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String,Object> update,
                                                 @PathVariable Long employeeId){
        EmployeeDTO employeeDTO= employeeService.updatePartialEmployeeById(employeeId,update);
        if(employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);

    }
}

