package bt1;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String producer;
    private double cost;
    private String description;
    public static int count=1;

    public Product() {
        this.productId = count++;
    }

    public Product(int productId, String productName, String producer, double cost, String description) {
        this.productId = count++;
        this.productName = productName;
        this.producer = producer;
        this.cost = cost;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }
}
