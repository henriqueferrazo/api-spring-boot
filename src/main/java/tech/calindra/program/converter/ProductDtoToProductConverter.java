package tech.calindra.program.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tech.calindra.program.dto.ProductDto;
import tech.calindra.program.model.Product;

@Component
public class ProductDtoToProductConverter implements Converter<ProductDto, Product> {

    @Override
    public Product convert(ProductDto productDto) {
        return Product.builder()
            .name(productDto.getName())
            .description(productDto.getDescription())
            .imageLink(productDto.getImageLink())
            .listPrice(productDto.getListPrice())
            .salePrice(productDto.getSalePrice())
            .build();
    }
}
