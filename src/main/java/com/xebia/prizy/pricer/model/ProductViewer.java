package com.xebia.prizy.pricer.model;

public class ProductViewer {

    private int barCode;

    private String description;

    private double avgPrice;

    private double lowestPrice;

    private double highestPrice;

    private double idealPrice;

    private int noOfPrices;

    private String instructions;

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getIdealPrice() {
        return idealPrice;
    }

    public void setIdealPrice(double idealPrice) {
        this.idealPrice = idealPrice;
    }

    public int getNoOfPrices() {
        return noOfPrices;
    }

    public void setNoOfPrices(int noOfPrices) {
        this.noOfPrices = noOfPrices;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


}
