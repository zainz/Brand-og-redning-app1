/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BE;

/**
 *
 * @author Nicolai
 */
public class Vehicle {
    
    int regnumber, odinnumber;
    String brand, model, description;
    
    public Vehicle(int regnumber, int odinnumber, String brand, String model, String description){
     this.regnumber = regnumber;
     this.odinnumber = odinnumber;
     this.brand = brand;
     this.model = model;
     this.description = description;
}

    public int getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(int regnumber) {
        this.regnumber = regnumber;
    }

    public int getOdinnumber() {
        return odinnumber;
    }

    public void setOdinnumber(int odinnumber) {
        this.odinnumber = odinnumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
