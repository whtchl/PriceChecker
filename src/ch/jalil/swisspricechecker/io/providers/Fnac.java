package ch.jalil.swisspricechecker.io.providers;

import android.content.Context;
import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;
import ch.jalil.swisspricechecker.io.URLs;

public class Fnac extends Providers{

	public Fnac (Context c) {
		super(c);
		type = PROVIDERS_TYPE.FNAC;
	}
	
	@Override
	public String linkFromQuerry(String formatedQuerry) {
		String adress = constructAdress(formatedQuerry);
		
		return "<a href=\"" + adress +"\">" + Const.Strings.BROWSE_FNAC + "</a>";
	}
	
	private String constructAdress(String formatedQuerry) {
		return URLs.FNAC_SITE + URLs.FNAC_PREFIX
				+ formatedQuerry;
	}

	@Override
	public String toString() {
		
		return "Fnac.com";
	}

}
