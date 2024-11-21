package br.edu.catolica.ppi.ms_merchant.domain;


import br.edu.catolica.ppi.ms_merchant.domain.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tb_order")
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<ItemOrder> items;

    @Column(name = "merchant_id")
    @NotNull(message = "merchantId nao pode ser nulo")
    private Long merchantId;

    @NotNull(message = "orderCode nao pode ser nulo")
    private String orderCode;

    @Positive
    private BigDecimal amount;

    @NotNull(message = "customerId nao pode ser nulo")
    private Long customerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
