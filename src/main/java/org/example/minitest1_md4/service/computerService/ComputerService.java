package org.example.minitest1_md4.service.computerService;

import org.example.minitest1_md4.model.Computer;
import org.example.minitest1_md4.repository.IComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ComputerService implements IComputerService{
    @Autowired
    private IComputerRepo computerRepo;
    @Override
    public List<Computer> findAll() {
        return computerRepo.findAll();
    }

    @Override
    public Computer findById(Long id) {
        return computerRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        computerRepo.deleteById(id);
    }

    @Override
    public void save(Computer computer) {
        computerRepo.save(computer);

    }

    @Override
    public Page<Computer> searchByName(String name, Pageable pageable) {
        return computerRepo.findComputerByComputerNameContaining(name,pageable);
    }
}
