package tech.calindra.program.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.calindra.program.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameLikeOrDescriptionLike(String name, String description);
}