package com.tearsmart.seckill.valid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-06
 */
public class Driver {
    @NotNull
    private String fullName;
    @Min(100)
    private int height;
    @Past
    @NotNull
    private Date dateOfBirth;

    public Driver(String fullName, int height, Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.height = height;
    }
}
