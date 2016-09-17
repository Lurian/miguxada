package com.example.android.tests.unit;

import com.example.android.app.BuildConfig;
import com.example.android.app.MainActivity;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@Config(emulateSdk=21, reportSdk=21, constants=BuildConfig.class)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {

	private MainActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = Robolectric.setupActivity(MainActivity.class);
		assertThat(activity, is(notNullValue()));
	}
}
