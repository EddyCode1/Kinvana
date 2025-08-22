package org.jrae.kinvana.dominio.service;

import org.jrae.kinvana.peristence.entity.Cliente;

import java.util.List;

public interface IClienteService {
    // firmas de metodos
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(Integer codigo);
    void guardarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
}
