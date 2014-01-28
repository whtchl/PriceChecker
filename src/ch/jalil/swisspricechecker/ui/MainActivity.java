package ch.jalil.swisspricechecker.ui;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.R;
import ch.jalil.swisspricechecker.Utils;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = "ch.jalil.swisspricechecker.ui.MainActivity";

	private TextView searchBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		searchBox = (EditText)findViewById(R.id.search_box);
		//protect from long input:
		searchBox.setFilters(new InputFilter[]
				{new InputFilter.LengthFilter(Const.Integers.QUERY_MAX_LENGTH)});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void launchSearch(View view) {
	     String URLInput = null;
	     try {
	    	 URLInput = Utils.handleInput(getUserInput());
			} catch (UnsupportedEncodingException e) {
				Log.d(TAG, Const.Strings.INPUT_ERROR);
				Toast.makeText(getApplicationContext(),
						Const.Strings.INPUT_ERROR, Toast.LENGTH_SHORT).show();
			}
	     
	     if (URLInput == null || URLInput.length() <= 0) {
	    	 return;
	     }
	     
	     Intent intent = new Intent(this, ResultActivity.class)
	     	.putExtra(Const.IntentKeys.INPUT, URLInput);
	     
	     startActivity(intent);
	 }
	
	
	
	private String getUserInput() {
//		Toast.makeText(getApplicationContext(), searchBox.getText().toString(), Toast.LENGTH_SHORT).show();
		return searchBox.getText().toString();
	}
	
}