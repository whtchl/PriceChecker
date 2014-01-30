package ch.jalil.swisspricechecker.io.providers;

import android.content.Context;
import ch.jalil.swisspricechecker.AppData;
import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;

public abstract class Providers {

	private Context mContext;
	
	public PROVIDERS_TYPE type;

	public abstract String linkFromQuerry(String querry);
	
	public abstract String toString();
	
	protected Providers (Context c) {
		mContext = c;
	}
	
	public String getPrefLanguage(){
		AppData mData = AppData.getInstance(mContext);
		return mData.getPreferredLanguage();
	}
	
	
}
