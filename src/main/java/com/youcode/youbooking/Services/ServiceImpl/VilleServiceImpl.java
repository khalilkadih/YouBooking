package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.Ville;
import com.youcode.youbooking.Repository.VilleRepository;
import com.youcode.youbooking.Services.VilleSerevice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VilleServiceImpl implements VilleSerevice {
    private final VilleRepository  villeRepository;

    public VilleServiceImpl(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    @Override
    public List<Ville> listVilles() {
        return villeRepository.findAll();
    }

    @Override
    public Ville addVille(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public void deleteVillel(Long id) {
        villeRepository.deleteById(id);
    }

    @Override
    public Ville findVilleByName(String villeName) {
        return villeRepository.findByNameVille(villeName);
    }

    @Override
    public Optional<Ville> findHVilleById(Long id) {
        return villeRepository.findById(id);
    }
}
