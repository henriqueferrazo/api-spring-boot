package tech.calindra.program.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tech.calindra.program.dto.ProductDto;
import tech.calindra.program.model.Product;
import tech.calindra.program.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllByName(String name) {
        var keyword = "%" + name + "%";
        return productRepository.findByNameLikeOrDescriptionLike(keyword, keyword);
    }

    public Optional<Product> findAllById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateAllProduct(Long id, ProductDto productDto) {
        Product updateProduct = productRepository.findById(id).get();
        updateProduct.setName(productDto.getName());
        updateProduct.setDescription(productDto.getDescription());
        updateProduct.setImageLink(productDto.getImageLink());
        updateProduct.setSalePrice(productDto.getSalePrice());
        updateProduct.setListPrice(productDto.getListPrice());
        return updateProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> search(String searchTerm, int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"id");
        return productRepository.search(searchTerm.toLowerCase(), pageRequest);
    }

    public Page<Product> findAll(){
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"id");
        return new PageImpl<>(productRepository.findAll(), pageRequest, size);
    }
}

