package com.ventas.Ventas.controller;

import com.ventas.Ventas.model.Producto;
import com.ventas.Ventas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Integer idProducto){
        return productoService.findById(idProducto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> create (@Valid @RequestBody Producto producto){
        return new ResponseEntity<>(productoService.create(producto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> update(@Valid @RequestBody Producto producto){
        return productoService.findById(producto.getIdProducto())
                .map(p->ResponseEntity.ok(productoService.update(producto)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idProducto){
        return productoService.findById(idProducto)
                .map(p->{
                    productoService.delete(idProducto);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}

