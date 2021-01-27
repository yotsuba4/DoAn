package cdio4.cots.foodoffer.model;

public class Food {
    private String food_ID;
    private String kindOfFood_ID;
    private String Restaurant_ID;
    private String Restaurant_Name;
    private String food_Name;
    private Double food_Price;
    private String food_Captions;
    private String food_urlImage;
    private int food_amount;

    public int getFood_amount() {
        return food_amount;
    }

    public void setFood_amount(int food_amount) {
        this.food_amount = food_amount;
    }

    public String getFood_ID() {
        return food_ID;
    }

    public void setFood_ID(String food_ID) {
        this.food_ID = food_ID;
    }

    public String getKindOfFood_ID() {
        return kindOfFood_ID;
    }

    public void setKindOfFood_ID(String kindOfFood_ID) {
        this.kindOfFood_ID = kindOfFood_ID;
    }

    public String getRestaurant_ID() {
        return Restaurant_ID;
    }

    public void setRestaurant_ID(String restaurant_ID) {
        Restaurant_ID = restaurant_ID;
    }

    public String getRestaurant_Name() {
        return Restaurant_Name;
    }

    public void setRestaurant_Name(String restaurant_Name) {
        Restaurant_Name = restaurant_Name;
    }

    public String getFood_Name() {
        return food_Name;
    }

    public void setFood_Name(String food_Name) {
        this.food_Name = food_Name;
    }

    public Double getFood_Price() {
        return food_Price;
    }

    public void setFood_Price(Double food_Price) {
        this.food_Price = food_Price;
    }

    public String getFood_Captions() {
        return food_Captions;
    }

    public void setFood_Captions(String food_Captions) {
        this.food_Captions = food_Captions;
    }

    public String getFood_urlImage() {
        return food_urlImage;
    }

    public void setFood_urlImage(String food_urlImage) {
        this.food_urlImage = food_urlImage;
    }

    public Food(String food_ID, String kindOfFood_ID, String restaurant_ID,
                String restaurant_Name, String food_Name, Double food_Price,
                String food_Captions, String food_urlImage) {
        this.food_ID = food_ID;
        this.kindOfFood_ID = kindOfFood_ID;
        Restaurant_ID = restaurant_ID;
        Restaurant_Name = restaurant_Name;
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.food_Captions = food_Captions;
        this.food_urlImage = food_urlImage;
    }
    //
    public Food(String food_ID, String kindOfFood_ID, String restaurant_ID,
                String food_Name, Double food_Price, String food_Captions, String food_urlImage) {
        this.food_ID = food_ID;
        this.kindOfFood_ID = kindOfFood_ID;
        this.Restaurant_ID = restaurant_ID;
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.food_Captions = food_Captions;
        this.food_urlImage = food_urlImage;
    }

    public Food() {
    }

    public Food(String food_Name, Double food_Price, String food_urlImage) {
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.food_urlImage = food_urlImage;
    }

    public Food(String food_ID, String food_Name, Double food_Price, String food_urlImage, int food_amount) {
        this.food_ID = food_ID;
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.food_urlImage = food_urlImage;
        this.food_amount = food_amount;
    }
}