package com.example.model.character;

import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

import java.io.Serializable;

/**
 * Class managing the basic statuses of a character.
 * @author Pedro Falcao
 */
public class CharacterStatuses implements Serializable{
    private Health health;
    private Energy energy;

    public CharacterStatuses(Health health, Energy energy) {
        this.health = health;
        this.energy = energy;
    }

    public Health getHealth() {
        return health;
    }

    public Energy getEnergy() {
        return energy;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }
}
