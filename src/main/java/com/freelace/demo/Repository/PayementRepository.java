package com.freelace.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelace.demo.Model.Payement;
public interface PayementRepository extends JpaRepository<Payement, Long> {
    
}
