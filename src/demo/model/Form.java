/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;

/**
 *
 * @author GIANG TINH
 */
public class Form {

    private String name;
    private String Image;
    private  String price;

    public Form(String name, String Image, String price) {
        this.name = name;
        this.Image = Image;
        this.price = price;
    }

    public Form() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Form{" + "name=" + name + ", Image=" + Image + ", price=" + price + '}';
    }
    
    
    
}
