package com.youcode.youbooking.Services;

import com.youcode.youbooking.Entity.Hotels;
import com.youcode.youbooking.Entity.Ville;
import com.youcode.youbooking.Repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VilleSerevice {
    List<Ville> listVilles();
    Ville addVille(Ville ville);
    void deleteVillel(Long id);
    Ville findVilleByName(String villeName);
    Optional<Ville> findHVilleById(Long id);

}
