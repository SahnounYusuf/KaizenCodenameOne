/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author bhk
 */
public class Velo {
    private int id;
    private String idu;
    private String brand;
    private String model;
    private String type;
    private String size;
    private String wheelsize;
    private String brakingtype;
    private String numberofspeed;
    private String quantity;
    private String color;
    private String weight;
    private String price;
    private String description;

    public Velo() {
    }

    public Velo(String idu, String brand, String model, String type, String size, String wheelsize, String brakingtype, String numberofspeed, String quantity, String color, String weight, String price, String description) {
        this.idu = idu;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.wheelsize = wheelsize;
        this.brakingtype = brakingtype;
        this.numberofspeed = numberofspeed;
        this.quantity = quantity;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    public Velo(String brand, String model, String type, String size, String wheelsize, String brakingtype, String numberofspeed, String quantity, String color, String weight, String price, String description) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.wheelsize = wheelsize;
        this.brakingtype = brakingtype;
        this.numberofspeed = numberofspeed;
        this.quantity = quantity;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    public Velo(int id, String idu, String brand, String model, String type, String size, String wheelsize, String brakingtype, String numberofspeed, String quantity, String color, String weight, String price, String description) {
        this.id = id;
        this.idu = idu;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.wheelsize = wheelsize;
        this.brakingtype = brakingtype;
        this.numberofspeed = numberofspeed;
        this.quantity = quantity;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getIdu() {
        return idu;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getWheelsize() {
        return wheelsize;
    }

    public String getBrakingtype() {
        return brakingtype;
    }

    public String getNumberofspeed() {
        return numberofspeed;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdu(String idu) {
        this.idu = idu;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWheelsize(String wheelsize) {
        this.wheelsize = wheelsize;
    }

    public void setBrakingtype(String brakingtype) {
        this.brakingtype = brakingtype;
    }

    public void setNumberofspeed(String numberofspeed) {
        this.numberofspeed = numberofspeed;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "Velo{" + "id=" + id + ", idu=" + idu + ", brand=" + brand + ", model=" + model + ", type=" + type + ", size=" + size + ", wheelsize=" + wheelsize + ", brakingtype=" + brakingtype + ", numberofspeed=" + numberofspeed + ", quantity=" + quantity + ", color=" + color + ", weight=" + weight + ", price=" + price + ", description=" + description + '}';
    }

    
    
}
