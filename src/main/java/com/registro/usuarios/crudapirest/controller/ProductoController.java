package com.registro.usuarios.crudapirest.controller;

import com.registro.usuarios.crudapirest.Service.ProductoService;
import com.registro.usuarios.crudapirest.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //NOTACIÓN IMPORTANTE, INDICAMOS QUE ES REST. INDICA QUE EL CLIENTE HARÁ UNA PETICIÓN
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return productoService.listarProducto();
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable("id") Integer id){
        try{
            Producto producto= productoService.BuscarProductoPorId(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        productoService.GuardarProducto(producto);
    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto,@PathVariable("id") Integer id){
        try{
            Producto productoExistente= productoService.BuscarProductoPorId(id);
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());

            productoService.GuardarProducto(productoExistente);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }
}
