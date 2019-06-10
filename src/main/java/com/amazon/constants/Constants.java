package com.amazon.constants;

public interface Constants {
	public static final String 	CONFIG_PATH = getConfigPath();
	
	public static String getConfigPath() {
		String path=System.getProperty("user.dir")+"/config/InputData.json";
		System.out.println("\n config json to be used: "+ path+ "\n");
		return path;
	}
}
