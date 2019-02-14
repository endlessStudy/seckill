package com.tearsmart.seckill.valid;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-06
 */
public class DriverLicense {
    @NotNull
    @Valid
    private Driver driver;
    @Digits(integer = 7, fraction = 0)
    private int number;

    public DriverLicense(Driver driver, int number) {
        this.driver = driver;
        this.number = number;
    }
}
