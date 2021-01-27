package cdio4.cots.foodoffer.model;

public class Restaurant {
    private String restaurant_ID;
    private String restaurant_Name;
    private String restaurant_X;
    private String restaurant_Y;
    private String restaurant_Image;
    private String restaurant_Phone;
    private String restaurant_Email;
    private String restaurant_Adress;
    private String restaurant_Stype;

    public String getRestaurant_ID() {
        return restaurant_ID;
    }

    public void setRestaurant_ID(String restaurant_ID) {
        this.restaurant_ID = restaurant_ID;
    }

    public String getRestaurant_Name() {
        return restaurant_Name;
    }

    public void setRestaurant_Name(String restaurant_Name) {
        this.restaurant_Name = restaurant_Name;
    }

    public String getRestaurant_X() {
        return restaurant_X;
    }

    public void setRestaurant_X(String restaurant_X) {
        this.restaurant_X = restaurant_X;
    }

    public String getRestaurant_Y() {
        return restaurant_Y;
    }

    public void setRestaurant_Y(String restaurant_Y) {
        this.restaurant_Y = restaurant_Y;
    }

    public String getRestaurant_Image() {
        return restaurant_Image;
    }

    public void setRestaurant_Image(String restaurant_Image) {
        this.restaurant_Image = restaurant_Image;
    }

    public String getRestaurant_Phone() {
        return restaurant_Phone;
    }

    public void setRestaurant_Phone(String restaurant_Phone) {
        this.restaurant_Phone = restaurant_Phone;
    }

    public String getRestaurant_Email() {
        return restaurant_Email;
    }

    public void setRestaurant_Email(String restaurant_Email) {
        this.restaurant_Email = restaurant_Email;
    }

    public String getRestaurant_Adress() {
        return restaurant_Adress;
    }

    public void setRestaurant_Adress(String restaurant_Adress) {
        this.restaurant_Adress = restaurant_Adress;
    }

    public String getRestaurant_Stype() {
        return restaurant_Stype;
    }

    public void setRestaurant_Stype(String restaurant_Stype) {
        this.restaurant_Stype = restaurant_Stype;
    }

    public Restaurant(String restaurant_ID, String restaurant_Name, String restaurant_X,
                      String restaurant_Y, String restaurant_Image, String restaurant_Phone,
                      String restaurant_Email, String restaurant_Adress, String restaurant_Stype) {
        this.restaurant_ID = restaurant_ID;
        this.restaurant_Name = restaurant_Name;
        this.restaurant_X = restaurant_X;
        this.restaurant_Y = restaurant_Y;
        this.restaurant_Image = restaurant_Image;
        this.restaurant_Phone = restaurant_Phone;
        this.restaurant_Email = restaurant_Email;
        this.restaurant_Adress = restaurant_Adress;
        this.restaurant_Stype = restaurant_Stype;
    }
}