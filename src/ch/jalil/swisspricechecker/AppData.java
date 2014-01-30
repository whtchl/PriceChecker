
package ch.jalil.swisspricechecker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
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
    private SharedPreferences mPrefs;
    
    private AppData(Context context) {
        mContext = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
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
    	return mPrefs.getString(Const.PrefKeys.LANGUAGE, null);
    }

    
    //##### History #####
    
    public boolean addToHistory(String entry) {
        if (entry == null) {
            return false;
        }
        
        List<String> history = null;
        
		try {
			history = getHistory();
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
        
        history.add(0, entry);
        
        truncateHistory(history);
        
        return mPrefs.edit().putString(Const.PrefKeys.HISTORY,
        		JSONArray.toJSONString(history)).commit();
    }

    @SuppressWarnings("unchecked")
	public List<String> getHistory() throws ParseException {
    	List<String> history = null;
    	String JSONHistory = mPrefs.getString(Const.PrefKeys.HISTORY, null);

    	if (JSONHistory != null) {
    		JSONParser parser = new JSONParser();
    		history = (List<String>)parser.parse(JSONHistory);
    	} else {
    		history = new LinkedList<String>();
    	}
    	return history;
    }
    
    
    /**
     * This method checks whether the history has become too long and, if so,
     * deletes the oldest entries. It should be called in the addToHistory
     * method so that it is truncated "in place" before it is being
     * stored in the shared prefs. It can handle a way too large history in case
     * of bug, but it should usually only remove one entry at a time.
     */
    private boolean truncateHistory(List<String> history) {

        if (history == null) {
            return false;
        }

        int historySize = history.size();

        if (historySize <= Const.Integers.MAX_HISTORY_SIZE) {
            return false;
        }        

        while (historySize > Const.Integers.MAX_HISTORY_SIZE) {
        	history.remove(historySize -1);
        	historySize = history.size();
        	Log.d(TAG, "history has been truncated once");
        }
        return true;
    }

    public boolean clearHistory() {
        return mPrefs.edit().remove(Const.PrefKeys.HISTORY).commit();
    }
	
}
