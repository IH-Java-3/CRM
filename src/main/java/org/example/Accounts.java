package org.example;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    final int idAccount;
    Account_Industry industry;
    int employeeCount;
    String city;
    String country;
    List<Leads> contactList = new ArrayList<>();  //aquí va una lista con la info de leads
    List<Opportunities> opportunityList = new ArrayList<>();
    int counter = 0;

    public Accounts(Account_Industry industry, int employeeCount, String city, String country, List<Leads> contactList, List<Opportunities> opportunityList) {
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setContactList(contactList);
        setOpportunityList(opportunityList);
        this.idAccount = counter++;
    }

    public Accounts() {
        this.idAccount = counter++;
    }

    public Account_Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Account_Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Leads> getContactList() {
        return contactList;
    }

    public void setContactList(List<Leads> contactList) {
        this.contactList = contactList;
    }

    public List<Opportunities> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunities> opportunityList) {
        this.opportunityList = opportunityList;
    }

    public int getIdAccount() {
        return idAccount;
    }

    @Override
    public String toString() {
        return
                "Account Id: " + idAccount + '\n' +
                        "Industry: " + industry + '\n' +
                        "EmployeeCount: " + employeeCount + '\n' +
                        "City: " + city + '\n' +
                        "Country: " + country + '\n' +
                        "Contact List: " + contactList + '\n' +
                        "OpportunityList: " + opportunityList + "";
    }
}