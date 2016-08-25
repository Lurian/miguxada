package com.example.model.character.status.health;

import com.example.model.character.attribute.AttributeChangeEvent;
import com.example.model.character.attribute.AttributeChangeListener;
import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.status.Status;

/**
 * Class representing the Health Status
 *
 * @author Lucas Andrade
 */
public class Health extends Status implements AttributeChangeListener{

    public Health(Long max) {
        super(max);
    }

    public Health(Long max, Long min) {
        super(max, min);
    }

    /**
     * Calculate the maximum Health of the status based on the resilience attribute
     * @param resilience Resilience that affects this instance of Health
     * @return Max Health value based on the resilience
     */
    public static Long calculateMaximum(Resilience resilience){
        return 100L + (resilience.getValue()*10);
    }

    @Override
    public void notifyChange(AttributeChangeEvent event) {
        if(event.getAttribute() instanceof Resilience){
            super.max = super.max + (event.getChangeAmount()*10);
        }
    }
}