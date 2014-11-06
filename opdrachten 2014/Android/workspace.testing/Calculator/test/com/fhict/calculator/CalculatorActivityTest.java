package com.fhict.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

@Config(manifest="../Calculator/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class CalculatorActivityTest {

	private CalculatorActivity activity;

	private TextView out;
	private TextView inputA;
	private TextView inputB;
	private RadioGroup radioGroup;

	private Button button;

	@Before
	public void setUp()
	{
		activity = Robolectric.buildActivity(CalculatorActivity.class).create().get();

		assertNotNull(activity);

		out = (TextView) activity.findViewById(R.id.textViewOutput);
		inputA = (TextView) activity.findViewById(R.id.editTextInputA);
		inputB = (TextView) activity.findViewById(R.id.editTextInputB);
		radioGroup = (RadioGroup) activity.findViewById(R.id.radioGroup);
		button = (Button) activity.findViewById(R.id.buttonCalculate);
	}
	
	  private void clickOnCalculateButton() {
	        button.performClick();
	    }

		private void setSomeInput() {
			Integer a = 4;
			Integer b = 3;

			inputA.setText(a.toString());
			inputB.setText(b.toString());
		}

		private void assertOutputText(String expected) {
			String actual = out.getText().toString();
			assertEquals(expected,actual);
		}

		@Test
		public void testOutputHintIsDisplayed() {
		assertTrue(false);
	}

	@Test
	public void testNumbersCanBeSetAreCalculatedWithAddAndDisplayed() throws Throwable {
		assertTrue(false);
	}

	@Test
	public void testErrorIsDisplayedWhenNoOperationSelected() {
		assertTrue(false);
	}
}