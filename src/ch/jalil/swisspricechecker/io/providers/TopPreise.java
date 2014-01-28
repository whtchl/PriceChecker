package ch.jalil.swisspricechecker.io.providers;

import ch.jalil.swisspricechecker.Const;
import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;
import ch.jalil.swisspricechecker.io.URLs;

public class TopPreise extends Providers{
	
	public TopPreise() {
		super();
		type = PROVIDERS_TYPE.TOPPREISE;
	}

	@Override
	public String linkFromQuerry(String formatedQuerry) {
		String adress = constructAdress(formatedQuerry);
		
		return "<a href=\"" + adress +"\" target=\"_blank\" style=\"target-new: tab;\">"
			+ Const.Strings.BROWSE_TOPPREISE + "</a>";
	}
	
	private String constructAdress(String formatedQuerry) {
		return URLs.TOPPREISE_SITE_PREFIX + getPrefLanguage() + URLs.TOPPREISE_SITE_SUFFIX
				+ URLs.TOPPREISE_PREFIX + formatedQuerry;
	}

	@Override
	public String toString() {
		
		return "TopPreise";
	}

}
