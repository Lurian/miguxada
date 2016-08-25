package com.example.model.character.status.energy;

import com.example.model.character.attribute.AttributeChangeEvent;
import com.example.model.character.attribute.AttributeChangeListener;
import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.status.Status;

/**
 * Subclass of status, representing a character's energy..
 *
 * @author Pedro Falcao
 */
public class Energy extends Status implements AttributeChangeListener {
    public Energy(Long max) {
        super(max);
    }

    public Energy(Long max, Long min) {
        super(max, min);
    }

    /**
     * Calculate the maximum Energy of the status based on the stamina attribute
     * @param stamina Stamina that affects this instance of Energy
     * @return Max Energy value based on the stamina
     */
    public static Long calculateMaximum(Stamina stamina){
        return 100L + (stamina.getValue()*10);
    }

    @Override
    public void notifyChange(AttributeChangeEvent event) {
        if(event.getAttribute() instanceof Stamina){
            super.max = super.max + (event.getChangeAmount()*10);
        }
    }
}
