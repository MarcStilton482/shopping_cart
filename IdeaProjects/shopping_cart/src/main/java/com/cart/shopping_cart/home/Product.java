package com.cart.shopping_cart.home;

public enum Product {
    AUTOMATIC_VACUUM_CLEANER("Automatic Vacuum Cleaner","cleaner.jpg",25000f),Wireless_Phone_Charger("Wireless Phone Charger","charger.jpg",7000f),
    Automatic_Home_Controller("Automatic Home Controller","control.jpg",185000f),Dishwasher("Dishwasher","dishwasher.jpg",57000f),
    Massage_Chair("Massage Chair","chair.jpg",70000f) , Washing_Machine("Washing Machine","machine.jpg",25000f) ,
    Automatic_Room_Heater("Room Heater","heater.jpg",14000f) , Neck_Massager("Neck Massager","massager.jpg",5500f), Bluetooth_Speaker("Bluetooth Speaker","speaker.jpg",3200f);

    public final String imageFile;
    public final float price;
    public final String itemname;

    Product(String itemname,String imageFile,float price){
        this.imageFile = imageFile;
        this.price = price;
        this.itemname = itemname;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getPrice() {
        return price;
    }
    public String getName() {
        return itemname;
    }
}
