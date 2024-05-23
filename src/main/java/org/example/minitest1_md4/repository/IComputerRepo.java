package org.example.minitest1_md4.repository;

import org.example.minitest1_md4.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepo extends JpaRepository<Computer, Long> {
    Page<Computer> findComputerByComputerNameContaining(String name, Pageable pageable);
}
