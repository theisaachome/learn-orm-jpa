package com.isaachome.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.model.Model;

public interface ModelRepo extends JpaRepository<Model, Integer> {

	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low,BigDecimal high);
	List<Model> findByModelTypeNameIn(List<String> types);
	
	List<Model> findByModelTypeName(String type);
}
