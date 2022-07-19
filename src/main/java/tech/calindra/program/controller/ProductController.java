package tech.calindra.program.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.calindra.program.dto.ProductDto;
import tech.calindra.program.model.Product;
import tech.calindra.program.service.ProductService;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ConversionService conversionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findByName(@RequestParam("name") String name) {
        return productService.findAllByName(name)
            .stream()
            .map(this::convert)
            .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable("id") Long id){
        return productService.findAllById(id).get();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@Valid @RequestBody ProductDto productDto) {
        LOG.info("Criando produto: [{}]", productDto);
        var product = conversionService.convert(productDto, Product.class);
        var savedProduct = productService.createProduct(product);
        return convert(savedProduct);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return productService.updateAllProduct(id, productDto);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable(value = "id") Long id) {
        productService.deleteProduct(id);
    }


    private ProductDto convert(Product product) {
        return conversionService.convert(product, ProductDto.class);
    }
}
