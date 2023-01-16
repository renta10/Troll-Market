package TrollMarket.Market.Dto;

import javax.persistence.criteria.CriteriaBuilder;

public class ProductDtoshow {
    private Integer id;
    private String name;
    private String category;
    private double price;
    private String description;
    private boolean status;

    public ProductDtoshow(){

    }

    public ProductDtoshow(Integer id, String name, String category, double price, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
