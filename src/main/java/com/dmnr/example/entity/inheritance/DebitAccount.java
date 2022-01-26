package com.dmnr.example.entity.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class DebitAccount extends Account {
    @Column(name = "overdraft_fee")
    private BigDecimal overdraftFee;

    public DebitAccount(long balance, String owner, int overdraftFee) {
        super();
        this.setBalance(BigDecimal.valueOf(balance));
        this.setOwner(owner);
        this.setOverdraftFee(BigDecimal.valueOf(overdraftFee));
    }

    public DebitAccount() {
    }

    public BigDecimal getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(BigDecimal overdraftFee) {
        this.overdraftFee = overdraftFee;
    }
}
