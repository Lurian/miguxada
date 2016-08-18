package com.example.model.character.status;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.android.app.BR;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a status.

 * @author Lucas Andrade, Pedro Falcão
 */
public abstract class Status extends BaseObservable implements Serializable {
    private final Long DEFAULT_MIN = 0L;
    private final Long ZERO = 0L;

    /** List of listeners of this Status **/
    List<StatusChangeListener> listenerList;

    /** Current value of the status **/
    @Bindable
    public Long current;

    /** Maximum value of the status **/
    @Bindable
    public Long max;

    /** Minimun value of the status **/
    private Long min = DEFAULT_MIN;

    public Status(Long max) {
        this.max = max;
        this.current = max;
 	    this.listenerList = new ArrayList<StatusChangeListener>();
    }

    public Status(Long max, Long min) {
        this.max = max;
        this.min = min;
        this.current = max;
 	    this.listenerList = new ArrayList<StatusChangeListener>();
    }

    /**
     * Increases the current status by a given amount, which cannot exceed the pre-set maximum value.
     * @param amount The amount to increase.
     * @exception IllegalArgumentException If the number passed as argument is negative.
     */
    public void increase(Long amount) {
        if (amount < ZERO) {
            throw new IllegalArgumentException("Negative numbers are not accepted!");
        }
        Long newAmount = this.getCurrent() + amount;
        if (newAmount >= this.getMax()) {
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
        if (amount < ZERO) {
            throw new IllegalArgumentException("Negative numbers are not accepted!");
        }
        Long newAmount = this.getCurrent() - amount;
        if (newAmount <= this.getMin()) {
            this.setCurrent(this.getMin());
        } else {
            this.setCurrent(newAmount);
        }
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
        notifyPropertyChanged(BR.max);
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        notifyPropertyChanged(BR.current);
        this.current = current;
    }

    public List<StatusChangeListener> getListenerList() {
        return listenerList;
    }

    public void setListenerList(List<StatusChangeListener> listenerList) {
        this.listenerList = listenerList;
    }

    public void addListener(StatusChangeListener listener) {
        this.listenerList.add(listener);
    }
}
