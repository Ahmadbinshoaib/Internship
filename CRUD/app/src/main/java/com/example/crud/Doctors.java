package com.example.crud;

public class Doctors {

    private int id;
    private String name;
    private String phoneNumber;
    private String cnic;
    private String qualification;
    private String specialization;

    public Doctors(int id, String name, String phoneNumber, String cnic, String qualification, String specialization) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cnic = cnic;
        this.qualification = qualification;
        this.specialization = specialization;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCnic() {
        return cnic;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSpecialization() {
        return specialization;
    }
}
