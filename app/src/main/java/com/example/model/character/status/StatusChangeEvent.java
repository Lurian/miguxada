package com.example.model.character.status;

/**
 * Class representing the event triggered by a status change.
 */
public class StatusChangeEvent {

    /** Old value before change **/
    private Long oldValue;

    /** New Value after change **/
    private Long newValue;

    /** The Status object that changed **/
    private Status status;

    /** Type of the event **/
    private StatusEventType type;

    public StatusChangeEvent(Long oldValue, Long newValue, Status status, StatusEventType type) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;
        this.type = type;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusEventType getType() {
        return type;
    }

    public void setType(StatusEventType type) {
        this.type = type;
    }
}
