package com.revature.onlinestoreapp.models;

public class PaymentInfo {
    String cardNum;
    String securityCode;
    int customerId;

    public PaymentInfo(String cardNum, String securityCode) {
        this.cardNum = cardNum;
        this.securityCode = securityCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
