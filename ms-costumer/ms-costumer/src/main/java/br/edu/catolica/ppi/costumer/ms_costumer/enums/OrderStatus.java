package br.edu.catolica.ppi.costumer.ms_costumer.enums;

public enum OrderStatus {

    ANALYZE("Em analise"),
    ACCEPTED("Pedido aceito"),
    PRODUCTION("Pedido em produção"),
    DELIVERY("Saiu para a entrega");

    private final String status;


    OrderStatus(String status) {
        this.status = status;
    }
}
