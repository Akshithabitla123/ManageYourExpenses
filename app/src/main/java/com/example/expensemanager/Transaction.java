package com.example.expensemanager;

public class Transaction {
    private String category;
    private String date;
    private String amount;
    private String mode;

    public Transaction(String category, String date, String amount,String mode) {
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.mode=mode;
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
}
