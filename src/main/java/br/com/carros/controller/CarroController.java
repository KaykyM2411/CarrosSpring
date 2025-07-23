package br.com.carros.controller;

import br.com.carros.entity.Carro;
import br.com.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro) {

        try {
            carroService.save(carro);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Carro>> findAll() {

        try{
            List<Carro> carros = carroService.findAll();
            return ResponseEntity.ok().body(carros);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id) {

        try {
            Carro carro = carroService.findById(id);
            return ResponseEntity.ok().body(carro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Carro> update(@RequestBody Carro carro,@PathVariable Long id) {

        try{
            this.carroService.update(carro, id);
            return ResponseEntity.ok().body(carro);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            carroService.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
