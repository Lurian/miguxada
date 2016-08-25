package com.example.model.character.attribute;

/**
 * Class representing the event triggered by a attribute change.
 */
public class AttributeChangeEvent {

    /** Old value before change **/
    private Long oldValue;

    /** New Value after change **/
    private Long newValue;

    /** The Status object that changed **/
    private Attribute attribute;

    public AttributeChangeEvent(Long oldValue, Long newValue, Attribute attribute) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.attribute = attribute;
    }

    public Long getOldValue() {
        return oldValue;
    }

    public void setOldValue(Long oldValue) {
        this.oldValue = oldValue;
    }

    public Long getNewValue() {
        return newValue;
    }

    public void setNewValue(Long newValue) {
        this.newValue = newValue;
    }

    /**
     * Returns the change amount.
     * @return Value of the change, can be negative.
     */
    public Long getChangeAmount() {
        return this.newValue - this.oldValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
