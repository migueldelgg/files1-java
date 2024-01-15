package entities;

public class Product {
    private String name;
    private Double price;
    private Integer qnt;

    public Product(){

    }

    public Product(String name, Double price, Integer qnt) {
        this.name = name;
        this.price = price;
        this.qnt = qnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Double value(){
        return price * qnt;
    }

}
