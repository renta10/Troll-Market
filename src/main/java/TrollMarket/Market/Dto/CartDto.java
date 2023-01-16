package TrollMarket.Market.Dto;


public class CartDto {
    private Integer id;
    private Integer quantity;
    private Integer buyerId;
    private Integer productId;
    private Integer shipmentId;

    public CartDto() {
    }

    public CartDto(Integer id, Integer quantity, Integer buyerId, Integer productId, Integer shipmentId) {
        this.id = id;
        this.quantity = quantity;
        this.buyerId = buyerId;
        this.productId = productId;
        this.shipmentId = shipmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }
}
