package br.com.samueltorga.repository.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@MappedEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bond {

    @Id
    @GeneratedValue
    private String id;
    @NotNull
    @NotBlank(message = "The name of person cannot be empty")
    private String name;
    private Instant dueDate;
    private BigDecimal value;
    private BigDecimal receiveTax;

}
