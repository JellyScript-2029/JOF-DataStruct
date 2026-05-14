package com.maven.model;

public class Account {

    //ENCAPSULATION
    private String name;
    private String accountNumber;
    private String pin;
    private double balance;

    public Account() {
    }

    public Account(String name, String accountNumber, String pin, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    //Authentication method
    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    //Check if account has sufficient funds
    public boolean hasSufficientFunds(double amount) {
        return this.balance >= amount;
    }

    //Withdraw funds from account
    public synchronized boolean withdraw(double amount) {
        if (hasSufficientFunds(amount)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    //Deposit funds to account
    public synchronized void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        this.balance += amount;
    }

    @Override
    public String toString() {
        return String.format("Account[%s] - %s | Balance: ₱%.2f", accountNumber, name, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber);
    }
}
