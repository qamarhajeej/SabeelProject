package com.example.sabeelproject;



public class DataClass {


    String Item;
    String Firstname;
    String Lastname;
    String Phone;
    String Address;
    String Details;


    public void setItem(String item) {
        Item = item;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setDetails(String details) {
        Details = details;
    }






    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    public String getDetails() {
        return Details;
    }

    public String getItem() {
        return Item;
    }




    public DataClass(String item, String firstname, String lastname, String phone, String address, String details) {

        Item = item;
        Firstname = firstname;
        Lastname = lastname;
        Phone = phone;
        Address = address;
        Details = details;
    }


    public DataClass() {


        //empty constructor
    }

    }
