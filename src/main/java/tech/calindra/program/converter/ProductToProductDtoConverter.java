package tech.calindra.program.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tech.calindra.program.dto.ProductDto;
import tech.calindra.program.model.Product;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(Product product) {
        return ProductDto.builder()
            .name(product.getName())
            .description(product.getDescription())
            .imageLink(product.getImageLink())
            .listPrice(product.getListPrice())
            .salePrice(product.getSalePrice())
            .build();
    }
}
