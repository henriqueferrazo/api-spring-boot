package tech.calindra.program.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
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

    public Product updateAllProduct(Long id, ProductDto productDto){
        Product updateProduct = productRepository.findById(id).get();
        updateProduct.setName(productDto.getName());
        updateProduct.setDescription(productDto.getDescription());
        updateProduct.setImageLink(productDto.getImageLink());
        updateProduct.setSalePrice(productDto.getSalePrice());
        updateProduct.setListPrice(productDto.getListPrice());
        return updateProduct;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
