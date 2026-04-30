package pe.joedayz.dfc.restapi.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import pe.joedayz.dfc.restapi.validation.SkuPrefix;

@Schema(description = "Datos para crear un producto")
public record CreateProductRequest(
    @NotBlank @Size(max = 120) @Schema(example = "Teclado mecánico") String name,
    @NotNull @DecimalMin("0.01") @Schema(example = "149.90") BigDecimal price,
    @NotBlank @SkuPrefix @Schema(example = "SKU-KEY-001") String sku) {}
