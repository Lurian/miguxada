package com.example.model.character;

import java.io.Serializable;

/**
 * Definition of a character containg his primary atributes and references to other data
 *
 * @author Lucas Andrade
 */
public class Character implements Serializable {

    /** Name of the character **/
    private String name;

    /** Biography of the character **/
    private String biography;

    /** Statuses of the character **/
    private CharacterStatuses statuses;

    /** Statuses of the character **/
    private CharacterAttributes attributes;

    public Character(String name, String biography, CharacterStatuses statuses, CharacterAttributes attributes){
        this.biography = biography;
        this.name = name;
        this.statuses = statuses;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public CharacterStatuses getStatus() {
        return this.statuses;
    }

    public CharacterAttributes getAttribute() {
        return attributes;
    }
}
