package com.taller.sexop.ProductService;

import com.taller.sexop.Entidad.Administrador;
import com.taller.sexop.Entidad.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ServiceAdmi {
    @Autowired
    private ServiceClientes serviceClientes;
    //Historial Administradores
    private List<Administrador> administradores;

    //administrador principal
    public ServiceAdmi() {
        administradores = new ArrayList<Administrador>();
        administradores.add(new Administrador(UUID.randomUUID(),"Keidy", "del carmen", "admi", 4000));
    }
    //Historial de administradores
    public List<Administrador> getAdministradors() {
        return administradores;
    }
    //mostrar administrador
    public Optional<Administrador> getAdministradorById(UUID id) {
        return administradores.stream().filter(administrador -> administrador.getIdAdministrador().equals(id)).findFirst();
    }
    //Nuevo administrador
    public UUID insertAdministrador(String nombre, String apellido, String cargo, float salario) {
        Administrador nuevoAdmin = new Administrador(UUID.randomUUID(),nombre,apellido,cargo,salario);
        administradores.add(nuevoAdmin);
        return nuevoAdmin.getIdAdministrador();
    }
    //actualizar
    public boolean actualizarAdmin (UUID id, String nombre, String apellido, String cargo, float salario) {
        for (Administrador admin : administradores ) {
            if (admin.getIdAdministrador().equals(id)) {
                admin.setNombre(nombre);
                admin.setApellido(apellido);
                admin.setCargo(cargo);
                admin.setSalario(salario);
                return true;
            }
        }
        return false;
    }
    //eliminar administrador
    public void eliminarAdministrador(UUID id) {
        administradores.remove(id);
    }
    //Cliente
    public List<Clientes> listaClientes(){
        return serviceClientes.getListaClientes();
    }
}
