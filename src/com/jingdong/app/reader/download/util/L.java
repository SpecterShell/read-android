package com.jingdong.app.reader.download.util;

import android.util.Log;

public class L {

	public final static String TAG = "J.Beyond";
	public final static String MATCH = "[%s::%d]";
	public final static String CONNECTOR = "-->";

	public final static boolean SWITCH = true;

	public static String buildHeader() {
		StackTraceElement stack = Thread.currentThread().getStackTrace()[4];
		return String.format(MATCH, /*stack.getClassName(),*/ stack.getMethodName(), stack.getLineNumber()) + CONNECTOR;
	}

	public static void v(Object msg) {
		if (SWITCH) {
			Log.v(TAG, buildHeader() + msg.toString());
		}
	}

	public static void d(Object msg) {
		if (SWITCH) {
			Log.d(TAG, buildHeader() + msg.toString());
		}
	}

	public static void i(Object msg) {
		if (SWITCH) {
			Log.i(TAG, buildHeader() + msg.toString());
		}
	}

	public static void w(Object msg) {
		if (SWITCH) {
			Log.w(TAG, buildHeader() + msg.toString());
		}
	}

	public static void e(Object msg) {
		if (SWITCH) {
			Log.e(TAG, buildHeader() + msg.toString());
		}
	}
}
