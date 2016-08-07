package com.example.model.character.status.health;

import com.example.model.character.status.Status;
import com.example.model.character.status.StatusChangeEvent;

/**
 * Class representing the Health Status
 * @author Lucas Andrade
 */
public class Health extends Status {

    public Health(Long max){
        super(max);
    }
    public Health(Long max, Long min) { super(max,min); }
}
