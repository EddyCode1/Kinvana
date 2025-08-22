package org.jrae.kinvana.dominio.service;

import org.jrae.kinvana.peristence.entity.crud.ClienteCrud;
import org.jrae.kinvana.peristence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService {

    // Inyeccion de dependecia de mi Repositorio(ClienteCrud) (Clien    teRepository)
    @Autowired
    private ClienteCrud crud;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = crud.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer codigo) {
        Cliente cliente = crud.findById(codigo).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        crud.save(cliente); //Agregar Nuevo y editar
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        crud.delete(cliente);
    }
}
