package com.example.android.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.model.character.Character;
import com.example.model.character.CharacterAttributes;
import com.example.model.character.CharacterStatuses;
import com.example.model.character.attribute.agility.Agility;
import com.example.model.character.attribute.resilience.Resilience;
import com.example.model.character.attribute.resolve.Resolve;
import com.example.model.character.attribute.stamina.Stamina;
import com.example.model.character.attribute.strength.Strength;
import com.example.model.character.attribute.wit.Wit;
import com.example.model.character.status.energy.Energy;
import com.example.model.character.status.health.Health;

public class MyApplication extends MultiDexApplication {

	@Override
	public void onCreate() {
		super.onCreate();
		attachBaseContext(this);
	}

	private Character character = getMockCharacter();

	public Character getCharacter() {
		return this.character;
	}

	/**
	 * Mock Generator of a Character object for test purposes.
	 *
	 * @return Mock Chracter
	 */
	private Character getMockCharacter() {
		Agility agility = new Agility(10L);
		Resilience resilience = new Resilience(10L);
		Resolve resolve = new Resolve(10L);
		Stamina stamina = new Stamina(10L);
		Strength strength = new Strength(10L);
		Wit wit = new Wit(10L);

		CharacterAttributes charAttr = new CharacterAttributes(agility, resilience, resolve, stamina, strength, wit);
		return new Character("João", "", charAttr);
	}

	@Override
	protected void attachBaseContext(Context base) {
		try {
			super.attachBaseContext(base);
		} catch (RuntimeException ignored) {
			// Multidex support doesn't play well with Robolectric yet
		}
	}
}
