package com.fhict.calculator.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.fhict.calculator.CalculatorActivity;
import com.fhict.calculator.R;

public class CalculatorActivityTest extends ActivityUnitTestCase<CalculatorActivity> {

    CalculatorActivity activity;
    private TextView out;
    private TextView inputA;
    private TextView inputB;
    private RadioGroup radioGroup;
	private Button button;

    public CalculatorActivityTest() {
        super(CalculatorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getInstrumentation().getTargetContext(),
                CalculatorActivity.class);
        startActivity(intent,null,null);
        activity = getActivity();

        out = (TextView) activity.findViewById(R.id.textViewOutput);
        inputA = (TextView) activity.findViewById(R.id.editTextInputA);
        inputB = (TextView) activity.findViewById(R.id.editTextInputB);
        radioGroup = (RadioGroup) activity.findViewById(R.id.radioGroup);
        button = (Button) activity.findViewById(R.id.buttonCalculate);
    }

    private void clickOnCalculateButton() {
        button.callOnClick();
    }

    private void setSomeInput() {
        Integer a = 4;
        Integer b = 3;
      

        inputA.setText(a.toString());
        inputB.setText(b.toString());
        
        
       
    }

    private void checkOutputText(String expected) {
        String actual = out.getText().toString();
        assertEquals(expected,actual);
    }
    
    @SmallTest
    @UiThreadTest
    public void testOutputHintIsDisplayed() {
    	
    	String actual2 = out.getHint().toString();
    	//checkOutputText("...");
    	if (actual2 == "..."){
    		assert(true);
    	}
    	else
    	{
    		assert(false);
    	}
    }

    @SmallTest
    @UiThreadTest
    public void testNumbersCanBeSetAndAreCalculatedWithAddAndDisplayed() throws Throwable {
    	setSomeInput();
    	radioGroup.check(R.id.radioButtonPlus);
    	clickOnCalculateButton();
    	checkOutputText("7.0");
    
    	//assertFalse(true); 
    }

    @SmallTest
    @UiThreadTest
    public void testErrorIsDisplayedWhenNoOperationSelected() {
    	
    	inputA.setText("4");
    	inputB.setText("2");
    	
    	clickOnCalculateButton();
    	
    	checkOutputText("Unknown operator");
    	
        //assertFalse(true);
     }
}
