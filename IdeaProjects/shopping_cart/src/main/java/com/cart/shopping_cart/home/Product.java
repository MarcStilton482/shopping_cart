package com.cart.shopping_cart.home;

public enum Product {
    AUTOMATIC_VACUUM_CLEANER("Automatic Vacuum Cleaner","cleaner.jpg",25000f,"This product .Is a Black gradient .Pro Robotic .Vacuum Cleaner,of brand. ILIFE.\n" +
            "Its cost is Twenty five thousand rupees. And rating is Four point four star.\n" +
            "It is ideal for Powerful Suction. Customized. Schedule Cleaning. Ideal for .Hard Floor. Low Pile. Carpet. Vacuum . and Mop\n"),
    Wireless_Phone_Charger("Wireless Phone Charger","charger.jpg",7000f,"A UNIGEN product. Which is of White gradient. And is a Magnetic Wireless Charger Stand. Compatible with all i Phone \n" +
            "Its cost is Seven thousand rupees. And rating is Four star.\n"),
    Automatic_Home_Controller("Automatic Home Controller","control.jpg",185000f,"This is an Alisan Smart Homes. Product of white gradient. It is a voice enabled. Home Controller. Which can be fit anywhere.\n" +
            "Its cost is  One lakh. Eighty five thousand rupees. And rating is four point seven star.\n"),
    Dishwasher("Dishwasher","dishwasher.jpg",57000f,"This is a Bosch product. Of Silver gradient. It is a 13 Place. Settings Dishwasher, suitable for family with upto four to five members. And is specially designed. For indian kitchens\n" +
            "Its cost is  Forty seven thousand rupees and rating is four point seven star\n"),
    Massage_Chair("Massage Chair","chair.jpg",70000f,"This product is a Black gradient\n Full Body Massage Chair\n ,of brand AGARO.\n" +
            "Its cost is seventy thousand rupees\n and rating is Four point two star.\n" +
            "Some of it's exhilarating features\n are Zero Gravity, Bluetooth Speaker, AI Voice Control, Handrail Shortcut Key, Rolling, Kneading, Tapping, Air Compression Massage and Lukewarm Heat\n") ,
    Washing_Machine("Washing Machine","machine.jpg",25000f,"This is a Samsung 7 kg\n Fully-Automatic\n Top Loading Washing Machine\n of Imperial Silver gradient\n and Diamond drum.\n" +
            "It is a four point five star product\n with two years warranty\n with additional features like quick wash\n, soak plus normal\n and delicates\n" +
            "Its cost is Twenty five thousand rupees.\n") ,
    Automatic_Room_Heater("Room Heater","heater.jpg",14000f,"A Havells Room Heater\n of white color 1500 Watt with PTC Ceramic Heating Element\n and 2 Heat Setting Room Heater.\n" +
            "It has smart sensors\n and turns off automatically\n when optimum temperature of room is acquired.\n" +
            "It is a four point six star\n product\n which cost forteen thousand rupees.") ,
    Neck_Massager("Neck Massager","massager.jpg",5500f,"This is a White gradient\n Neck Massager\n of HOUZAIDE World. It is a battery powered\n silicon product\n which is clinically tested\n and approved, suitable for thirty yeas and above.\n" +
            "Its cost is fifty thousand five hundred\n and four point two star rating."),
    Bluetooth_Speaker("Bluetooth Speaker","speaker.jpg",3200f,"KANHAEMPIRE Wireless Night Light LED Touch Lamp Speaker"+" with Portable Bluetooth"+" and HiFi Speaker"+" with Smart Colour Changing"+" Touch Control,"+" USB Rechargeable\n" +
            "Its rating is four star"+" and cost thirty two hundred");

    public final String imageFile;
    public final float price;
    public final String itemname;
    public final String info;

    Product(String itemname,String imageFile,float price,String info){
        this.imageFile = imageFile;
        this.price = price;
        this.itemname = itemname;
        this.info = info;
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
    public String getIn(){
        return info;
    }
}
