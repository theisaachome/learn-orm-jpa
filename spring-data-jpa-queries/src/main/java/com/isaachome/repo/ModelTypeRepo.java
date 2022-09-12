package com.isaachome.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isaachome.model.ModelType;


public interface ModelTypeRepo extends JpaRepository<ModelType, Long> {
	ModelType findByName(String name);
	List<ModelType> findByNameIsNull();
	List<ModelType> findByNameIsNotNull();
}
