package com.ventas.Ventas.controller;

import com.ventas.Ventas.model.DetalleVenta;
import com.ventas.Ventas.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> findAll(){
        return ResponseEntity.ok(detalleVentaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> findById(@PathVariable("id")Integer idDetalleVenta){
        return detalleVentaService.findById(idDetalleVenta)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<DetalleVenta> create(@Valid @RequestBody DetalleVenta detalleVenta){
        return new ResponseEntity<>(detalleVentaService.create(detalleVenta), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DetalleVenta> update (@Valid @RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.findById(detalleVenta.getIdDetalleVenta())
                .map(d->ResponseEntity.ok(detalleVentaService.update(detalleVenta)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>delete (@PathVariable("id") Integer idDetalleVenta){
        return detalleVentaService.findById(idDetalleVenta)
                .map(d->{
                    detalleVentaService.delete(idDetalleVenta);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

}
