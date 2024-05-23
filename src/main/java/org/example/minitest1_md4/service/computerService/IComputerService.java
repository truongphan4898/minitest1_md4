package org.example.minitest1_md4.service.computerService;

import org.example.minitest1_md4.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IComputerService {
    List<Computer> findAll();
    Computer findById(Long id);
    void deleteById(Long id);
    void save(Computer computer);
    Page<Computer> searchByName(String name, Pageable pageable);
}
