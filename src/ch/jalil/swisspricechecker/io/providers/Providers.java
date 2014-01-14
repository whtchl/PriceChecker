package ch.jalil.swisspricechecker.io.providers;

import ch.jalil.swisspricechecker.Const.PROVIDERS_TYPE;

public abstract class Providers {
	
	public PROVIDERS_TYPE type;

	public abstract String linkFromQuerry(String querry);
	
	public abstract String toString();
	
	public String getPrefLanguage(){
		//TODO make something usefull
		return "fr";
	}
	
	
}
