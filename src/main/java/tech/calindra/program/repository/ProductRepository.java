package tech.calindra.program.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import tech.calindra.program.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByNameLikeOrDescriptionLike(String name, String description);
    Page<Product> search(@Param("name") String searchTerm, Pageable pageable);
}