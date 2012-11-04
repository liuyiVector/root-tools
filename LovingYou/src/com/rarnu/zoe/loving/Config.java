package com.rarnu.zoe.loving;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Config {

	public static final String TOKEN = "token";
	public static final String SECRET_TOKEN = "secret_token";
	
	private static final String HINT_ENABLED = "hint%d_enabled";
	private static final String HINT_TIME = "hint%d_time";

	private static SharedPreferences sp = null;
	private static void initSharedPreference(Context context) {
		if (sp == null) {
			sp = PreferenceManager.getDefaultSharedPreferences(context);
		}
	}
	
	public static boolean getHintEnabled(Context context, int index) {
		initSharedPreference(context);
		String key = String.format(HINT_ENABLED, index);
		return sp.getBoolean(key, false);
		
	}
	
	public static void setHintEnabled(Context context, int index, boolean enabled) {
		initSharedPreference(context);
		String key = String.format(HINT_ENABLED, index);
		sp.edit().putBoolean(key, enabled).commit();
	}
	
	public static long getHintTime(Context context, int index, long def) {
		initSharedPreference(context);
		String key = String.format(HINT_TIME, index);
		return sp.getLong(key, def);
	}
	
	public static void setHintTime(Context context, int index, long value) {
		initSharedPreference(context);
		String key = String.format(HINT_TIME, index);
		sp.edit().putLong(key, value).commit();
	}
}
