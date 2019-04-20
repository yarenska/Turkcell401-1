package com.example.asuss.turkcell401.com.example.asuss.turkcell401.models;

public class Diet {
    int foodPicture;
    String foodName;
    String totalCalorie;

    public Diet(int foodPicture, String foodName, String totalCalorie){
        this.foodPicture = foodPicture;
        this.foodName = foodName;
        this.totalCalorie = totalCalorie;
    }

    public void setFoodPicture(int foodPicture) {
        this.foodPicture = foodPicture;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setTotalCalorie(String totalCalorie) {
        this.totalCalorie = totalCalorie;
    }

    public int getFoodPicture() {
        return foodPicture;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getTotalCalorie() {
        return totalCalorie;
    }
}
