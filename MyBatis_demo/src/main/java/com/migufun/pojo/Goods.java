package com.migufun.pojo;

/**
 * @author NJR10byh
 * @date 2022/8/4 15:53:31
 * @description
 */

public class Goods {
    private int id;
    private String goods_name;
    private String brand;
    private Double price;
    private String description;

    public Goods() {
    }

    public Goods(int id, String goods_name, String brand, Double price, String description) {
        this.id = id;
        this.goods_name = goods_name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
