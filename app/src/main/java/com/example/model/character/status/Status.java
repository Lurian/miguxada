package com.example.model.character.status;

/**
 * Class representing a status.
 * @author Lucas Andrade
 */
public abstract class Status {

    private Long current;
    private Long max;

    public Status(Long max){
        this.max = max;
        this.current = max;
    }

    /**
     * Increases the current status by an amount.
     * @param amount The amount to increase.
     */
    public void increase(Long amount){
        this.current += amount;
    }

    /**
     * Decreases the current status by an amount.
     * @param amount The amount to decrease.
     */
    public void decrease(Long amount){
        this.current -= amount;
    }

    public Long getMax() {
        return max;
    }

    protected void setMax(Long max) {
        this.max = max;
    }

    public Long getCurrent() {
        return current;
    }

    protected void setCurrent(Long current) {
        this.current = current;
    }
}
