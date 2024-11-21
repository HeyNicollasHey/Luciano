package br.edu.catolica.ppi.ms_merchant.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemOrder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long product;

    @Positive(message = "Quantidade do produto invalida")
    private Integer quantity;

    private BigDecimal subAmount;

    @ManyToOne
    private Order order;
}
