package com.example.model.character.status.health;

import com.example.model.character.status.Status;

/**
 * Created by Lucas on 06/08/2016.
 */
public class Health extends Status {

    public Health(Long max){
        super(max);
    }

    @Override
    public void increase(Long amount) {
        if (amount < 0) { throw new IllegalArgumentException("Negative Argument!"); }
        Long newAmount = this.getMax() + amount;
        if (newAmount >= this.getMax()) {
            this.setCurrent(this.getMax());
        } else {
            this.setCurrent(newAmount);
        }
    }

    @Override
    public void decrease(Long amount) {
        if (amount < 0) { throw new IllegalArgumentException("Negative Argument!"); }
        Long newAmount = this.getMax() - amount;
        if (newAmount <= 0L) {
            this.setCurrent(0L);
        } else {
            this.setCurrent(newAmount);
        }
    }
}
