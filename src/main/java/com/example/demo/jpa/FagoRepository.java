package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.eneity.FagoData;

@Repository
public interface FagoRepository extends JpaRepository<FagoData, String>{

	List<FagoData> findByKey(String key);
	boolean existsByKey(String key);
}
