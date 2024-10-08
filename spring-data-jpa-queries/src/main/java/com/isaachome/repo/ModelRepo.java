package com.isaachome.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isaachome.model.Model;

public interface ModelRepo extends JpaRepository<Model, Integer> {

	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low,BigDecimal high);
	List<Model> findByModelTypeNameIn(List<String> types);
	
	List<Model> findByModelTypeName(String type);
	
	@Query("SELECT m FROM Model m WHERE m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
	List<Model> queryByPriceRangeAndWoodTpe(
			@Param("lowest") BigDecimal lowest,
			@Param("highest") BigDecimal highest,
			@Param("wood") String wood);
	
	List<Model> findAllModelsByType(@Param("name")String name);
}
