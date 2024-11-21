package br.edu.catolica.ppi.costumer.ms_costumer.domain;

import br.edu.catolica.ppi.costumer.ms_costumer.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "tb_order")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String orderCode;

    @NotNull
    private String customerId;

    @NotNull
    private Long merchantId;

    @NotNull
    private Long amount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemOrder> items;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
