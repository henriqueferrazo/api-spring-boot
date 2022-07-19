package tech.calindra.program.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.ConversionService;
import tech.calindra.program.dto.ProductDto;
import tech.calindra.program.model.Product;
import tech.calindra.program.service.ProductService;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ConversionService conversionService;

    private ProductController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ProductController(productService, conversionService);
    }

    @Test
    void create() {
        // GIVEN
        var parameter = ProductDto.builder().build();
        var product = Product.builder().build();

        when(conversionService.convert(parameter, Product.class)).thenReturn(product);
        when(productService.createProduct(product)).thenReturn(product);
        when(conversionService.convert(product, ProductDto.class)).thenReturn(parameter);

        // WHEN
        var productDto = controller.create(parameter);

        // THEN
        verify(productService).createProduct(product);
        assertNotNull(productDto);
    }
}