package org.jrae.kinvana.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.kinvana.dominio.service.IClienteService;
import org.jrae.kinvana.peristence.entity.Cliente;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {
    @Autowired
    IClienteService clienteService;
    private List<Cliente> clientes;
    private Cliente clienteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    String sl = System.lineSeparator();

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clientes = this.clienteService.listarClientes();
        this.clientes.forEach(cliente -> logger.info(cliente.toString() + sl));
    }

    public void agregarCliente(){
        this.clienteSeleccionado = new Cliente();
    }

    public void guardarCliente(){
        logger.info("Cliente guardar" + this.clienteSeleccionado);
        //Agregar (insertar)
        if (this.clienteSeleccionado.getCodigoCliente() == null ){
            this.clienteService.guardarCliente(this.clienteSeleccionado);
            this.clientes.add(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente agregado"));
        }
        //Modificar(update)
        else {
            this.clienteService.guardarCliente(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente Actualizado") );
        }
        // ocultar la ventana modal
        PrimeFaces.current().executeScript( "PF('VentaModaCliente').hide()");

        PrimeFaces.current().ajax().update("formulario-clientes:mensaje-emergente",
                "formulario-clientes:tabla-clientes");
        // Actualizar la tabla con un metodo AJAX
    }

    public void eliminarCliente(){
            //Mostrar em consola
        logger.info("Cliente a eliminar" + this.clienteService);
            //Llamar a nuestro servicion de eliminar cliente
        this.clienteService.eliminarCliente(clienteSeleccionado);
            // Eliminarlo de la lista clientes
        this.clientes.remove(clienteSeleccionado);
            //limpear nuestro sercicio de eliminacion de Clientes
        this.clienteSeleccionado = null;
        //Enviar un mensaje emergente
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente eliminado"));
        // Actualizar la tabla cpm akas
        PrimeFaces.current().ajax().update("formulario-clientes:mensaje-emergente",
                "formulario-clientes:tabla-clientes");
    }

}
