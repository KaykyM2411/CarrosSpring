package br.com.carros.service;

import br.com.carros.entity.Carro;
import br.com.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro) {
        carroRepository.save(carro);

        return "Carro salvo com sucesso!";
    }
    public List<Carro> findAll() {

        return this.carroRepository.findAll();
    }

    public Carro findById(Long id) {

        return carroRepository.findById(id).get();
    }

    public Carro update(Carro carro, Long id) {
        carro.setId(id);
        return carroRepository.save(carro);
    }

    public void delete(Long id) {
        carroRepository.deleteById(id);
    }
}
