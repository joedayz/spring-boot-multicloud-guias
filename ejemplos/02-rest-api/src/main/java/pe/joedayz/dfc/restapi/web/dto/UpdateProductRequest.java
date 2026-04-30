package pe.joedayz.dfc.restapi.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Schema(description = "Actualización parcial de nombre y precio (el SKU no cambia en este ejemplo)")
public record UpdateProductRequest(
    @NotBlank @Size(max = 120) String name,
    @NotNull @DecimalMin("0.01") BigDecimal price) {}
