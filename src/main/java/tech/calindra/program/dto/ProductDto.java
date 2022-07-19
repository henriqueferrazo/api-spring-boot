package tech.calindra.program.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.calindra.program.validator.PriceValidation;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PriceValidation
public class ProductDto {

    @NotBlank(message = "O campo nome deve ser definido")
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String imageLink;

    @Min(1)
    @NotNull
    private BigDecimal listPrice;

    @Min(1)
    @NotNull
    private BigDecimal salePrice;
}