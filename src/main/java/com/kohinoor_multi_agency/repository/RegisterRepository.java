package com.kohinoor_multi_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kohinoor_multi_agency.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer> {

  public Register findByEmailId(String emailID);
  public Register findByEmailIdAndPassword(String emailID,String password);

}
