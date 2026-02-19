package com.example.springboottwebutorial.services;

import com.example.springboottwebutorial.Exceptions.DepartmentNotFoundException;
import com.example.springboottwebutorial.Exceptions.ResourceNotFoundException;
import com.example.springboottwebutorial.dto.DepartmentDTO;
import com.example.springboottwebutorial.entities.DepartmentEntity;
import com.example.springboottwebutorial.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentService(ModelMapper modelMapper, DepartmentRepository departmentRepository) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }


    public Optional<DepartmentDTO> GetDepartmentById(Long departmentId) {
        //boolean exist=departmentRepository.existsById(departmentId);
        //(!exist) throw new NoSuchElementException("Department no exist by this id"+departmentId);
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        return departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity1,DepartmentDTO.class));
    }


    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class))
                .collect(Collectors.toList());
    }


    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity departmentEntity=modelMapper.map(inputDepartment,DepartmentEntity.class);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO inputDepartment, Long departmentId) {
        boolean exist=departmentRepository.existsById(departmentId);
        if(!exist) throw new DepartmentNotFoundException("Department  not found");
        DepartmentEntity departmentEntity=modelMapper.map(inputDepartment,DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public boolean departmentDelete(Long departmentId) {
        boolean exist=departmentRepository.existsById(departmentId);
        if(!exist) throw new DepartmentNotFoundException("department not founr");
        departmentRepository.deleteById(departmentId);
        return true;
    }
}
