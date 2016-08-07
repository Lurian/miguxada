package com.example.model.character;

import com.example.model.character.status.Status;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

/**
 * Class managing the basic statuses of a character.
 * @author Pedro Falcao
 */
public class CharacterStatus {
    private Health health;
    private Energy energy;

    public CharacterStatus(Health health, Energy energy) {
        this.health = health;
        this.energy = energy;
    }

    public Health getHealth() {
        return (Health) health;
    }

    public Energy getEnergy() {
        return (Energy) energy;
    }
}
