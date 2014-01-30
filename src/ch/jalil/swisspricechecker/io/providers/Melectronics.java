package ch.jalil.swisspricechecker.io.providers;

import android.content.Context;
import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;
import ch.jalil.swisspricechecker.io.URLs;

public class Melectronics extends Providers{
	
	public Melectronics (Context c) {
		super(c);
		type = PROVIDERS_TYPE.MELECTRONICS;
	}

	@Override
	public String linkFromQuerry(String formatedQuerry) {
		String adress = constructAdress(formatedQuerry);
		
		return "<a href=\"" + adress +"\" target=\"_blank\" style=\"target-new: tab;\">"
			+ Const.Strings.BROWSE_MELECTRONICS + "</a><br>Hint: select desktop view if asked";
	}
	
	private String constructAdress(String formatedQuerry) {
		return URLs.MELECTRONICS_SITE + URLs.MELECTRONICS_PREFIX + getPrefLanguage()
				+ URLs.MELECTRONICS_PREFIX2 + formatedQuerry;
	}

	@Override
	public String toString() {
		
		return "M-Electronics";
	}

}
