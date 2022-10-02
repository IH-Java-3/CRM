package org.example;

public class Opportunities {
    final int idOpportunity;
    Opportunities_product product;
    int quantity;
    //List<Leads> decisionMaker = new ArrayList<>(); //los datos del lead
    Leads decisionMaker;
    Opportunities_status status;
    int counter = 0;

    public Opportunities(Opportunities_product product, int quantity, Leads decisionMaker, Opportunities_status status) {
        this.idOpportunity = counter++;
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public Opportunities_product getProduct() {
        return product;
    }

    public void setProduct(Opportunities_product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Leads getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Leads decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Opportunities_status getStatus() {
        return status;
    }

    public void setStatus(Opportunities_status status) {
        this.status = status;
    }

    public int getIdOportunity() {
        return idOpportunity;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return
                "Opportunity Id: " + idOpportunity + '\n' +
                        "Product: " + product + '\n' +
                        "Quantity: " + quantity + '\n' +
                        "DecisionMaker: " + decisionMaker + '\n' +
                        "Status: " + status + "";
    }
}
