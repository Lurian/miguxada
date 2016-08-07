package com.example.model.character.status;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a status.
 *
 * @author Lucas Andrade
 */
public abstract class Status {

    /** List of listeners of this Status **/
    List<StatusChangeListener> listenerList;

    /** Current value of the status **/
    private Long current;

    /** Maximum value of the status **/
    private Long max;

    public Status(Long max) {
        this.max = max;
        this.current = max;
        this.listenerList = new ArrayList<StatusChangeListener>();
    }

    /**
     * Increases the current status by an amount.
     *
     * @param amount The amount to increase.
     */
    public void increase(Long amount) {
        this.current += amount;
    }

    /**
     * Decreases the current status by an amount.
     *
     * @param amount The amount to decrease.
     */
    public void decrease(Long amount) {
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
