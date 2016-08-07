package com.example.model.character.status.energy;

import com.example.model.character.status.Status;

/**
 * Subclass of status, representing a character's energy..
 * @author Pedro Falcao
 */
public class Energy extends Status {
    public Energy(Long max){ super(max); }
    public Energy(Long max, Long min) { super(max,min); }
}
