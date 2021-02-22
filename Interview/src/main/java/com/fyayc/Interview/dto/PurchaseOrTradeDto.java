package com.fyayc.Interview.dto;

public class PurchaseOrTradeDto {

    private boolean isPurchased;

    private Integer primaryUserId;

    private Integer secondaryUserId;

    private Integer primaryProductId;

    private Integer secondaryProductId;

    public boolean getIsPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    public Integer getPrimaryUserId() {
        return primaryUserId;
    }

    public void setPrimaryUserId(Integer primaryUserId) {
        this.primaryUserId = primaryUserId;
    }

    public Integer getSecondaryUserId() {
        return secondaryUserId;
    }

    public void setSecondaryUserId(Integer secondaryUserId) {
        this.secondaryUserId = secondaryUserId;
    }

    public Integer getPrimaryProductId() {
        return primaryProductId;
    }

    public void setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
    }

    public Integer getSecondaryProductId() {
        return secondaryProductId;
    }

    public void setSecondaryProductId(Integer secondaryProductId) {
        this.secondaryProductId = secondaryProductId;
    }
}
