package com.example.model.character.status;

/**
 * Interface for Observer Pattern of Status Change
 *
 * @author Lucas Andrade
 */
public interface StatusChangeListener {
    public void notifyChange(StatusChangeEvent event);
}
