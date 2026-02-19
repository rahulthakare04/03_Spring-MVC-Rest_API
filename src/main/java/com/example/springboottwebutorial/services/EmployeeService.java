package com.example.springboottwebutorial.services;

import com.example.springboottwebutorial.Exceptions.ResourceNotFoundException;
import com.example.springboottwebutorial.dto.EmployeeDTO;
import com.example.springboottwebutorial.entities.EmployeeEntity;
import com.example.springboottwebutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }



    public Optional<EmployeeDTO> getEmployeesById(Long id) {
        Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(id);

         return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1,EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
         return employeeEntities.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .toList();
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputemployee) {
        EmployeeEntity saveEmployeeEntity=modelMapper.map(inputemployee,EmployeeEntity.class);

         EmployeeEntity savedEmployeeEntity=employeeRepository.save(saveEmployeeEntity);
         return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeId) {
        boolean isexist= employeeRepository.existsById(employeeId);
        if(!isexist) throw new ResourceNotFoundException("Employee not found");
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    public boolean employeeExistById(Long employeeoId){

        return employeeRepository.existsById(employeeoId);
    }
    public Boolean deleteEmployeeById(Long employeeId) {
       boolean exist=employeeExistById(employeeId);
       if(!exist) throw new ResourceNotFoundException("Employee not found");
       employeeRepository.deleteById(employeeId);
       return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> update) {
        boolean exist=employeeExistById(employeeId);
        if(!exist) throw new ResourceNotFoundException("Employee not found");
        EmployeeEntity employeeEntity=employeeRepository.findById(employeeId).get();
        update.forEach((field,value)->{
            Field fieldToBeUpdated=ReflectionUtils.getRequiredField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }
}
