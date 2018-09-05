package com.relexsolutions.javaassignment.api;

import java.time.LocalDate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Forecast {
    @Nonnull public String productCode;
    @Nonnull public LocalDate date;
    public double quantity;

    public Forecast(@Nonnull String productCode, @Nonnull LocalDate date, double quantity) {
        this.productCode = productCode;
        this.date = date;
        this.quantity = quantity;
    }
}
