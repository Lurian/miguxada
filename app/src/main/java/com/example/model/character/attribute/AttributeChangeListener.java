package com.example.model.character.attribute;

/**
 * Interface for Observer Pattern of Status Change
 *
 * @author Lucas Andrade
 */
public interface AttributeChangeListener {
    public void notifyChange(AttributeChangeEvent event);
}
