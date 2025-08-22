package org.jrae.kinvana.peristence.entity.crud;

import org.jrae.kinvana.peristence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface    ClienteCrud extends JpaRepository<Cliente, Integer> {
    // Puede sustituir el dao
    // Esta interfaz tiene todos metodos genericos del crud
}
