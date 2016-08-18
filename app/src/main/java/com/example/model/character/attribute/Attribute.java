package com.example.model.character.attribute;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.android.app.BR;
import java.io.Serializable;

/**
 * Class representing an attribute and his properties.
 *
 * @author Lucas Andrade
 */
public abstract class Attribute extends BaseObservable implements Serializable {

    /** Current value of the attribute **/
    @Bindable
    public Long value;

    public Attribute(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        notifyPropertyChanged(BR.value);
        this.value = value;
    }

    /**
     * Increase the value of the attribute.
     * @param amount The amount to increase.
     * @exception IllegalArgumentException If the number passed as argument is negative.
     */
    public void increase(Long amount) {
        if(amount < 0){
            throw new  IllegalArgumentException("Negative numbers are not accepted!");
        }
        this.value = value + amount;
    }

    /**
     * Decrease the value of the attribute.
     * Can't be lower than 0;
     * @param amount The amount to decrease.
     * @exception IllegalArgumentException If the number passed as argument is negative.
     */
    public void decrease(Long amount) {
        if(amount < 0){
            throw new  IllegalArgumentException("Negative numbers are not accepted!");
        }
        if((value - amount) < 1L) {
            this.value = 1L;
        } else {
            this.value = value - amount;
        }
    }
}
