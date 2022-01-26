package com.dmnr.example.entity.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CreditAccount  extends  Account{
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    public CreditAccount() {
    }

    public CreditAccount(double balance, String owner, double creditLimit) {
        super();
        this.setBalance(BigDecimal.valueOf(balance));
        this.setCreditLimit( BigDecimal.valueOf(creditLimit));
        this.setOwner(owner);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
