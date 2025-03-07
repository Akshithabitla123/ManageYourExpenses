package com.example.expensemanager;

public class Transaction {
    private String category;
    private String date;
    private String amount;
    private String mode;
    private String type;

    public Transaction(String category, String date, String amount,String mode,String type) {
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.mode=mode;
        this.type=type;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }
    public String getMode(){
        return mode;
    }
    public String getType(){
        return type;
    }
}
