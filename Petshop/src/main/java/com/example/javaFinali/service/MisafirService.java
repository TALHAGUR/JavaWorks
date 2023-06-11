package com.example.javaFinali.service;

import com.example.javaFinali.model.Misafir;
import com.example.javaFinali.repository.MisafirRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MisafirService {

    private final MisafirRepository misafirRepository;

    public MisafirService(MisafirRepository misafirRepository) {
        this.misafirRepository = misafirRepository;
    }

    public void misafirEkle(Misafir misafir){
        misafirRepository.save(misafir);
    }

    public void misafirSil(Long id){
        misafirRepository.deleteById(id);
    }

    public Misafir misafirGetir(Long id){
        Optional<Misafir> byId = misafirRepository.findById(id);
        return byId.get();
    }
    public List<Misafir> misafirListele(){
        List<Misafir> misafirler = new ArrayList<>();
        Iterable<Misafir> all = misafirRepository.findAll();
        all.forEach(misafirler::add);
        return misafirler;


    }

}
