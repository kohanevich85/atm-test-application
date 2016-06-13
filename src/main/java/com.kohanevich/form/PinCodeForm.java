package com.kohanevich.form;

import com.kohanevich.annotation.PinCode;

/**
 * Created by Denis on 6/11/2016
 */
public class PinCodeForm {
    @PinCode
    private Integer pinCode;
    public Integer getPinCode() {
        return pinCode;
    }
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
