package TrollMarket.Market.Dto;

import TrollMarket.Market.Entity.Chart;

import java.text.NumberFormat;
import java.util.Locale;

public class CartDtoShow {

    private Integer id;
    private String product;
    private Integer quantity;
    private String shipment;
    private String seller;
    private String totalPrice;

    public CartDtoShow(){

    }

    public CartDtoShow(Integer id, String product,
                       Integer quantity, String shipment, String seller, String totalPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.shipment = shipment;
        this.seller = seller;
        this.totalPrice = totalPrice;
    }

    public CartDtoShow(Chart chart) {
        this.id = chart.getIdChart();
        this.product = chart.getProduct().getProductName();
        this.quantity = chart.getQuantity();
        this.shipment = chart.getShipment().getShipmentName();
        double totalPrice = (chart.getProduct().getPrice() * chart.getQuantity() )+ chart.getShipment().getPrice();
        this.totalPrice = NumberFormat.getCurrencyInstance(new Locale("id","ID")).format((double) totalPrice);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
