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
        this.value = value;
        notifyPropertyChanged(BR.value);
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
        Long newValue = this.getValue() + amount;
        setValue(newValue);
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
        Long newValue = this.getValue() - amount;
        if(newValue < 1L) {
            setValue(1L);
        } else {
            setValue(newValue);
        }
    }
}
