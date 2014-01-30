
package ch.jalil.swisspricechecker;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import ch.jalil.swisspricechecker.io.providers.Amazon;
import ch.jalil.swisspricechecker.io.providers.Fnac;
import ch.jalil.swisspricechecker.io.providers.MediaMarkt;
import ch.jalil.swisspricechecker.io.providers.Melectronics;
import ch.jalil.swisspricechecker.io.providers.Providers;
import ch.jalil.swisspricechecker.io.providers.TopPreise;

/**
 * Singleton object containing various utilities for the app.
 * 
 * @author jalil
 */
public final class AppData {
	//can add implements OnSharedPreferenceChangeListener

    private static final String TAG = "ch.jalil.swisspricechecker.AppData";

    private static AppData sInstance;
    
    private List<Providers> mProvidersList;

    private Context mContext;
//    private SharedPreferences mPrefs;
    
    private AppData(Context context) {
        mContext = context;
//        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
//        mPrefs.registerOnSharedPreferenceChangeListener(this);
    	
    	constructProvidersList();
    	
    }

    public static synchronized AppData getInstance(Context c) {
        if (sInstance == null) {
            sInstance = new AppData(c.getApplicationContext());
        }

        /* some cool thing that can be done
        if (c instanceof ActivityA) {
            someArg = FAST;
        } else if (c instanceof ActivityB) {
            someArg = MEDIUM;
        } else {
            someArg = SLOW;
        }
        */
        return sInstance;
    }
    
    public List<Providers> getProvidersList() {
		return mProvidersList;
	}
    
    
    private void constructProvidersList() {
    	mProvidersList = new ArrayList<Providers>();
    	
    	mProvidersList.add(new MediaMarkt(mContext));
    	mProvidersList.add(new Fnac(mContext));
    	mProvidersList.add(new Amazon(mContext));
    	mProvidersList.add(new Melectronics(mContext));
    	mProvidersList.add(new TopPreise(mContext));
    }
    
    public String getPreferredLanguage() {
    	SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    	return sharedPrefs.getString(Const.PrefKeys.LANGUAGE, null);
    }

	
}
