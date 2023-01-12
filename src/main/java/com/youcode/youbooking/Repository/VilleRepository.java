package com.youcode.youbooking.Repository;

import com.youcode.youbooking.Entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
    Ville findByNameVille(String nameVille);

}
