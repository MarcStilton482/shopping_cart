package com.cart.shopping_cart.home;

public enum Product {
    AUTOMATIC_VACUUM_CLEANER("cleaner.jpg",25000f),Wireless_Phone_Charger("charger.jpg",7000f),
    Automatic_Home_Controller("control.jpg",185000f),Dishwasher("dishwasher.jpg",57000f),
    Massage_Chair("chair.jpg",70000f) , Washing_Machine("machine.jpg",25000f) ,
    Automatic_Room_Heater("heater.jpg",14000f) , Neck_Massager("massager.jpg",5500f), Bluetooth_Speaker("speaker.jpg",3200f);

    public final String imageFile;
    public final float price;

    Product(String imageFile,float price){
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getPrice() {
        return price;
    }
}
