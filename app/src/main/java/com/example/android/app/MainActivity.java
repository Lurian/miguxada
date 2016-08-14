package com.example.android.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent i = new Intent();

		final Bundle b = new Bundle();
		Character c = getMockCharacter();
		b.putSerializable("TestChar", c);

		final Button statusButton = (Button) findViewById(R.id.charStatus_button);
		statusButton.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View v) {
				  Intent statusScreenIntent = new Intent(getApplicationContext(), StatusScreenActivity.class);
				  statusScreenIntent.putExtras(b);
				  startActivity(statusScreenIntent);
			  }
			});

        final Button attributesButton = (Button) findViewById(R.id.charAttributes_button);
        attributesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent statusScreenIntent = new Intent(getApplicationContext(), AttributeScreenActivity.class);
                statusScreenIntent.putExtras(b);
                startActivity(statusScreenIntent);
            }
        });

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (toolbar != null) {
			toolbar.setTitle(R.string.app_name);
			setSupportActionBar(toolbar);
		}
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
			}
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		};
		drawerLayout.setDrawerListener(drawerToggle);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment())
					.commit();
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		// Perform action on click
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_main, container, false);
		}
	}

	/**
	 * Mock Generator of a Character object for test purposes.
	 * @return Mock Chracter
	 */
	private Character getMockCharacter() {
		CharacterStatuses charStat = new CharacterStatuses(new Health(100L), new Energy(100L));

		Agility agility = new Agility(10L);
		Resilience resilience = new Resilience(10L);
		Resolve resolve = new Resolve(10L);
		Stamina stamina = new Stamina(10L);
		Strength strength = new Strength(10L);
		Wit wit = new Wit(10L);

		CharacterAttributes charAttr = new CharacterAttributes(agility, resilience, resolve, stamina, strength, wit);
		return new Character("João", "", charStat, charAttr);
	}
}
