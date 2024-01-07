package com.registro.usuarios.crudapirest.Service;

import com.registro.usuarios.crudapirest.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarProducto();
    Producto GuardarProducto(Producto producto);

    Producto BuscarProductoPorId(Integer id);
    void eliminarProducto(Integer id);
}
