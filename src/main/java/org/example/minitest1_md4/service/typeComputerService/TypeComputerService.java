package org.example.minitest1_md4.service.typeComputerService;

import org.example.minitest1_md4.model.TypeComputer;
import org.example.minitest1_md4.repository.ITypeComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeComputerService implements ITypeComputerService{
    @Autowired
    private ITypeComputerRepo typeComputerRepo;
    @Override
    public List<TypeComputer> findAll() {
        return typeComputerRepo.findAll();
    }
}
