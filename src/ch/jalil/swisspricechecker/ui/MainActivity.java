package ch.jalil.swisspricechecker.ui;

import java.io.UnsupportedEncodingException;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import ch.jalil.swisspricechecker.AppData;
import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.R;
import ch.jalil.swisspricechecker.Utils;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = "ch.jalil.swisspricechecker.ui.MainActivity";

	private TextView searchBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PreferenceManager.setDefaultValues(getApplicationContext(), R.xml.pref_general, false);
		
		setContentView(R.layout.activity_main);
		searchBox = (EditText)findViewById(R.id.search_box);
		//protect from long input:
		searchBox.setFilters(new InputFilter[]
				{new InputFilter.LengthFilter(Const.Integers.QUERY_MAX_LENGTH)});
		
	}

	//############## Menu and ActionBar ##############

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_help:
	            openHelp();
	            return true;
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        case R.id.action_history:
	        	openHistory();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void openHelp() {
		Intent helpIntent = new Intent(this, HelpActivity.class);
		startActivity(helpIntent);
	}
	
	public void openSettings() {
		Intent settingsIntent = new Intent(this, SettingsActivity.class);
		startActivity(settingsIntent);
	}
	
	public void openHistory() {
		Intent historyIntent = new Intent(this, HistoryActivity.class);
		startActivity(historyIntent);
	}

	
	//############## Search helpers ##############
	
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
	     
	     addToHistory(getUserInput());
	     
	     Intent intent = new Intent(this, ResultActivity.class)
	     	.putExtra(Const.IntentKeys.INPUT, URLInput);
	     
	     startActivity(intent);
	 }
	
	
	
	private String getUserInput() {
		return searchBox.getText().toString();
	}
	
	private boolean addToHistory(String input) {
		AppData mData = AppData.getInstance(getApplicationContext());
		return mData.addToHistory(input);
	}
	
}