package com.phoneBook;

public class PhoneBook {
    int id;
    String name;
    String adress;
    String number;

    public PhoneBook( String name, String adress, String number) {

        this.name = name;
        this.adress = adress;
        this.number = number;
    }
    public String print(){
        return name+","+adress+","+number;
    }
    @Override
    public String toString() {
        return "\n"+name+"-"+adress+"-"+number;
    }
}
