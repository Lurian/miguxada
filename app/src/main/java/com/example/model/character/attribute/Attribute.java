package com.example.model.character.attribute;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.android.app.BR;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an attribute and his properties.
 *
 * @author Lucas Andrade
 */
public abstract class Attribute extends BaseObservable implements Serializable {

    /** Current value of the attribute **/
    @Bindable
    public Long value;

    public List<AttributeChangeListener> ACListeners;

    /**
     * Default Constructor
     * @param value Initial Value of the attribute
     */
    public Attribute(Long value) {
        this.value = value;
        this.ACListeners = new ArrayList<AttributeChangeListener>();
    }

    /**
     * Constructor with listeners parameter
     * @param value Initial Value of the attribute
     * @param ATClisteners Initial listeners of the attribute
     */
    public Attribute(Long value, List<AttributeChangeListener> ATClisteners){
        this(value);
        this.ACListeners = ATClisteners;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    public List<AttributeChangeListener> getACListeners() {
        return ACListeners;
    }

    public void setACListeners(List<AttributeChangeListener> ACListeners) {
        this.ACListeners = ACListeners;
    }

    public void addACListener(AttributeChangeListener ACListeners) {
        this.ACListeners.add(ACListeners);
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
        Long oldValue = this.getValue();
        Long newValue = this.getValue() + amount;
        setValue(newValue);
        notifyChangeToListeners(oldValue, newValue);
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
        Long oldValue = this.getValue();
        if(newValue < 1L) {
            notifyChangeToListeners(oldValue, 1L);
            setValue(1L);
        } else {
            notifyChangeToListeners(oldValue, newValue);
            setValue(newValue);
        }
    }

    private void notifyChangeToListeners(Long oldValue, Long newValue){
        AttributeChangeEvent ACE = new AttributeChangeEvent(oldValue, newValue, this);
        for(AttributeChangeListener ACL : ACListeners){
            ACL.notifyChange(ACE);
        }
    }
}
