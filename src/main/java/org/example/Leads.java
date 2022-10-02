package org.example;

public class Leads {
    String name;
    String phoneNumber;
    String email;
    String companyName;
    final int idLead;
    static int counter = 0;

    public Leads(String name, String phoneNumber, String email, String companyName) {
        this.idLead = counter++;
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getIdLead() {
        return idLead;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return
                "Lead Id: " + idLead +'\n' +
                "Name: " + name + '\n' +
                "Phone Number:" + phoneNumber + '\n' +
                "E-mail: " + email + '\n' +
                "Company Name: " + companyName + "";
    }
}