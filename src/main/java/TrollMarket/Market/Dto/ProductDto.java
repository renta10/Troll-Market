package TrollMarket.Market.Dto;


public class ProductDto {
    private Integer id;
    private String productName;
    private String category;
    private String description;
    private double price;
    private Boolean status;

    public ProductDto(){

    }

    public ProductDto(Integer id, String productName, String category,
                      String description, Double price, Boolean status) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
