package ch.jalil.swisspricechecker.io.providers;

import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;
import ch.jalil.swisspricechecker.io.URLs;

public class MediaMarkt extends Providers{
	
	public MediaMarkt() {
		super();
		type = PROVIDERS_TYPE.MEDIAMARKT;
	}

	@Override
	public String linkFromQuerry(String formatedQuerry) {
		String adress = constructAdress(formatedQuerry);
		
		return "<a href=\"" + adress +"\" target=\"_blank\" style=\"target-new: tab;\">" + Const.Strings.BROWSE_MEDIAMARKT + "</a>";
	}
	
	private String constructAdress(String formatedQuerry) {
		return URLs.MEDIAMARKT_SITE + getPrefLanguage() + URLs.MEDIAMARKT_PREFIX
				+ formatedQuerry; //+ URLs.MEDIAMARKT_SUFIX;
	}

	@Override
	public String toString() {
		
		return "MediaMarkt";
	}

}
