package pe.joedayz.dfc.pedidos.dto;

public record OrderView(String orderId, String productId, int quantity, String productName, Double productPrice) {}
