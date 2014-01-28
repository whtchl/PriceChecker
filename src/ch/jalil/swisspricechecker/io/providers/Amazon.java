package ch.jalil.swisspricechecker.io.providers;

import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;
import ch.jalil.swisspricechecker.io.URLs;

public class Amazon extends Providers{
	
	public Amazon() {
		super();
		type = PROVIDERS_TYPE.AMAZON;
	}

	@Override
	public String linkFromQuerry(String formatedQuerry) {
		String adress = constructAdress(formatedQuerry);
		
		return "<a href=\"" + adress +"\" target=\"_blank\" style=\"target-new: tab;\">" + Const.Strings.BROWSE_AMAZON + "</a>";
	}
	
	private String constructAdress(String formatedQuerry) {
		return URLs.AMAZON_SITE + URLs.AMAZON_PREFIX + formatedQuerry;
	}

	@Override
	public String toString() {
		
		return "Amazon.fr";
	}

}
