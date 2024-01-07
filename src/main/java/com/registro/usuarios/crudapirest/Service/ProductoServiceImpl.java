package com.registro.usuarios.crudapirest.Service;

import com.registro.usuarios.crudapirest.entities.Producto;
import com.registro.usuarios.crudapirest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository repository;
    @Override
    public List<Producto> listarProducto() {
        return repository.findAll();
    }

    @Override
    public Producto GuardarProducto(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto BuscarProductoPorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void eliminarProducto(Integer id) {
        repository.deleteById(id);
    }
}
