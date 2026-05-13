package com.maven.model;

import java.time.LocalDateTime;

/**
 * ABSTRACTION: Interface defining payment method contracts POLYMORPHISM:
 * Multiple implementations for different payment types INHERITANCE: Concrete
 * classes inherit from abstract base
 */
public interface PaymentProcessor {

    /**
     * Process payment with given amount
     *
     * @param amount The amount to process
     * @return Success message or error message
     */
    String process(double amount);

    /**
     * Get the payment method name
     *
     * @return Payment method identifier
     */
    String getMethodName();

    /**
     * Get receipt details
     *
     * @return Formatted receipt string
     */
    String getReceipt();
}

/**
 * ABSTRACT BASE CLASS: Common functionality for all payment methods
 */
abstract class AbstractPaymentProcessor implements PaymentProcessor {

    protected double amount;
    protected LocalDateTime timestamp;

    public AbstractPaymentProcessor(double amount) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String getReceipt() {
        return String.format("[%s] Payment: ₱%.2f | Time: %s",
                getMethodName(), amount, timestamp);
    }
}

/**
 * POLYMORPHISM: Cash Payment implementation INHERITANCE: Extends
 * AbstractPaymentProcessor
 */
class CashPayment extends AbstractPaymentProcessor {

    private double cashGiven;
    private double changeGiven;

    public CashPayment(double cashGiven) {
        super(0);
        this.cashGiven = cashGiven;
    }

    @Override
    public String process(double amount) {
        this.amount = amount;

        if (cashGiven < amount) {
            return "FAILED|Insufficient cash given";
        }

        this.changeGiven = cashGiven - amount;
        return "SUCCESS";
    }

    @Override
    public String getMethodName() {
        return "CASH";
    }

    public double getChange() {
        return changeGiven;
    }

    public double getCashGiven() {
        return cashGiven;
    }

    @Override
    public String getReceipt() {
        return String.format("[%s] Amount: ₱%.2f | Paid: ₱%.2f | Change: ₱%.2f",
                getMethodName(), amount, cashGiven, changeGiven);
    }
}

/**
 * POLYMORPHISM: Card Payment implementation INHERITANCE: Extends
 * AbstractPaymentProcessor
 */
class CardPayment extends AbstractPaymentProcessor {

    private Account account;
    private boolean processed = false;

    public CardPayment(Account account, double amount) {
        super(amount);
        this.account = account;
    }

    @Override
    public String process(double amount) {
        this.amount = amount;

        if (account == null) {
            return "FAILED|Account not found";
        }

        if (!account.hasSufficientFunds(amount)) {
            return "FAILED|Insufficient balance: ₱" + String.format("%.2f", account.getBalance());
        }

        account.withdraw(amount);
        processed = true;
        return "SUCCESS";
    }

    @Override
    public String getMethodName() {
        return "CARD";
    }

    public Account getAccount() {
        return account;
    }

    public boolean isProcessed() {
        return processed;
    }

    @Override
    public String getReceipt() {
        return String.format("[%s] Account: %s | Amount: ₱%.2f | Remaining Balance: ₱%.2f",
                getMethodName(), account.getAccountNumber(), amount, account.getBalance());
    }
}

/**
 * POLYMORPHISM: Digital Wallet Payment (Future extension) INHERITANCE: Extends
 * AbstractPaymentProcessor
 */
class DigitalWalletPayment extends AbstractPaymentProcessor {

    private String walletId;
    private double walletBalance;

    public DigitalWalletPayment(String walletId, double walletBalance) {
        super(0);
        this.walletId = walletId;
        this.walletBalance = walletBalance;
    }

    @Override
    public String process(double amount) {
        this.amount = amount;

        if (walletBalance < amount) {
            return "FAILED|Insufficient wallet balance";
        }

        this.walletBalance -= amount;
        return "SUCCESS";
    }

    @Override
    public String getMethodName() {
        return "DIGITAL_WALLET";
    }

    public String getWalletId() {
        return walletId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    @Override
    public String getReceipt() {
        return String.format("[%s] Wallet: %s | Amount: ₱%.2f | Remaining: ₱%.2f",
                getMethodName(), walletId, amount, walletBalance);
    }
}
