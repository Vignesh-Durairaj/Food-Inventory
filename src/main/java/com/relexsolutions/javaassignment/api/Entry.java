package com.relexsolutions.javaassignment.api;

import java.time.LocalDate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.MoreObjects;

public class Entry {
    @Nonnull public String code;
    @Nonnull public String componentCode;
    public double multiplier;
    @Nullable public LocalDate startDate;
    @Nullable public LocalDate endDate;

    public Entry(@Nonnull String code, @Nonnull String componentCode, double multiplier, @Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        this.code = code;
        this.multiplier = multiplier;
        this.componentCode = componentCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(@Nonnull String code) {
        this.code = code;
    }

    @Nonnull
    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(@Nonnull String componentCode) {
        this.componentCode = componentCode;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    @Nullable
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@Nullable LocalDate startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("code", code)
            .add("componentCode", componentCode)
            .add("multiplier", multiplier)
            .add("startDate", startDate)
            .add("endDate", endDate)
            .toString();
    }
}
