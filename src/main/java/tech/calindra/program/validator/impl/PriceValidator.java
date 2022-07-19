package tech.calindra.program.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import tech.calindra.program.dto.ProductDto;
import tech.calindra.program.validator.PriceValidation;

public class PriceValidator implements ConstraintValidator<PriceValidation, ProductDto> {

    @Override
    public boolean isValid(ProductDto productDto, ConstraintValidatorContext context) {
        return productDto.getListPrice().compareTo(productDto.getSalePrice()) > 0;
    }
}
