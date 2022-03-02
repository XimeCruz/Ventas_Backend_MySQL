package com.ventas.Ventas.controller;

import com.ventas.Ventas.model.Venta;
import com.ventas.Ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> findAll(){
        return ResponseEntity.ok(ventaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> findById(@PathVariable("id") Integer idVenta){
        return ventaService.findById(idVenta)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venta> create (@Valid @RequestBody Venta Venta){
        return new ResponseEntity<>(ventaService.create(Venta), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Venta> update(@Valid @RequestBody Venta Venta){
        return ventaService.findById(Venta.getIdVenta())
                .map(p->ResponseEntity.ok(ventaService.update(Venta)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idVenta){
        return ventaService.findById(idVenta)
                .map(p->{
                    ventaService.delete(idVenta);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
