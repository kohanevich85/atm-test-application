package com.kohanevich.form;

import com.kohanevich.annotation.ValidAmount;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * Created by Denis on 6/12/2016
 */
public class WithdrawForm {

    @Min(1)
    @Max(100000)
    @ValidAmount
    private Integer amount;

    public BigDecimal getAmount() {
        return new BigDecimal(amount);
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
