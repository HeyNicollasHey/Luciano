package br.edu.catolica.ppi.ms_merchant.domain.enums;

public enum OrderStatus {

    ANALYZE("Pedido em analise"),
    PRODUCTION("Pedido em produção"),
    DONE("Pedido pronto"),
    DELIVERY("Saiu para a entrega");

    private String status;

    private OrderStatus(String status){
        this.status = status;
    }
}
