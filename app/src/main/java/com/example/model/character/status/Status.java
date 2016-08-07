package com.example.model.character.status;

/**
 * Class representing a status.
 * @author Lucas Andrade, Pedro Falcão
 */
public abstract class Status {
    private Long DEFAULT_MIN = 0L;

    private Long current;
    private Long max;
    private Long min = DEFAULT_MIN;

    public Status(Long max) {
        this.setMax(max);
        this.setCurrent(max);
    }

    public Status(Long max, Long min) {
        this.setMax(max);
        this.setMin(min);
        this.setCurrent(max);
    }

    /**
     * Increases the current status by a given amount, which cannot exceed the pre-set maximum value.
     * @param amount The amount to increase.
     * @exception IllegalArgumentException If the number passed as argument is negative.
     */
    public void increase(Long amount) {
        if (amount < this.getMin()) { throw new IllegalArgumentException("Negative numbers are not accepted!"); }
        Long newAmount = this.getMax() + amount;
        if (newAmount >= this.getCurrent()) {
            this.setCurrent(this.getMax());
        } else {
            this.setCurrent(newAmount);
        }
    }

    /**
     * Decreases the current status by a given amount, which cannot exceed the pre-set minimum value, whose default is 0.
     * @param amount The amount to decrease.
     * @exception IllegalArgumentException If the number passed as argument is negative.
     */
    public void decrease(Long amount){
        if (amount < this.getMin()) { throw new IllegalArgumentException("Negative numbers are not accepted!"); }
        Long newAmount = this.getCurrent() - amount;
        if (newAmount <= this.getMin()) {
            this.setCurrent(this.getMin());
        } else {
            this.setCurrent(newAmount);
        }
    }

    public Long getMin() { return min; }

    public void setMin(Long min) { this.min = min; }

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
