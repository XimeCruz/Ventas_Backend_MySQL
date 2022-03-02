package com.ventas.Ventas.controller;

import com.ventas.Ventas.model.Producto;
import com.ventas.Ventas.model.TipoProducto;
import com.ventas.Ventas.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipoProducto")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public ResponseEntity<List<TipoProducto>> findAll(){
        return ResponseEntity.ok(tipoProductoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> findById(@PathVariable("id") Integer idTipoProducto){
        return tipoProductoService.findById(idTipoProducto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoProducto> create (@Valid @RequestBody TipoProducto tipoProducto){
        return new ResponseEntity<>(tipoProductoService.create(tipoProducto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TipoProducto> update(@Valid @RequestBody TipoProducto tipoProducto){
        return tipoProductoService.findById(tipoProducto.getIdTipoProducto())
                .map(p->ResponseEntity.ok(tipoProductoService.update(tipoProducto)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idTipoProducto){
        return tipoProductoService.findById(idTipoProducto)
                .map(p->{
                    tipoProductoService.delete(idTipoProducto);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
