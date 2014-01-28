package ch.jalil.swisspricechecker.ui;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
import ch.jalil.swisspricechecker.AppData;
import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.R;
import ch.jalil.swisspricechecker.io.providers.Providers;

public class ResultActivity extends ActionBarActivity {

	private String userInput = null;
	private AppData appData = null;
	private List<Providers> providersList = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		//Retrieving extra:
		
		userInput = getIntent().getStringExtra(Const.IntentKeys.INPUT);
		Toast.makeText(getApplicationContext(),
				userInput, Toast.LENGTH_SHORT).show();		
		
		//Getting list of providers
		appData = AppData.getInstance(getApplicationContext());
		
		providersList = appData.getProvidersList();
		
		displayResults();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	private void displayResults() {
		//TODO make something dynamic here
		TextView tv = null;
		
		for (Providers p : providersList) {
			
			
			switch(p.type){
			case MEDIAMARKT:
				tv = (TextView)findViewById(R.id.mediamarkt_tv);
				break;
			case FNAC:
				tv = (TextView)findViewById(R.id.fnac_tv);
				break;
			case AMAZON:
				tv = (TextView)findViewById(R.id.amazon_tv);
				break;
			case MELECTRONICS:
				tv = (TextView)findViewById(R.id.melectronics_tv);
				break;
			case TOPPREISE:
				tv = (TextView)findViewById(R.id.toppreise_tv);
				break;				
			default:
				tv = null;
				break;
			}
			
			if (tv == null) {
				return;
			}
			
			tv.setText(Html.fromHtml(p.linkFromQuerry(userInput)));
			//makes link clickable
			tv.setMovementMethod(LinkMovementMethod.getInstance());
		}
		
	}
}
