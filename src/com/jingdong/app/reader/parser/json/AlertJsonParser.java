package com.jingdong.app.reader.parser.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.jingdong.app.reader.util.MZLog;

public class AlertJsonParser implements JSONParser {
	private static final String ALERTS = "general_alerts";

	@Override
	public JSONArray getJsonArrayFromString(String jsonString) {
		JSONArray jsonArray = null;
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(jsonString);
			jsonArray = jsonObject.getJSONArray(ALERTS);
		} catch (JSONException e) {
			MZLog.e(getClass().getSimpleName(), Log.getStackTraceString(e));
		}
		return jsonArray;
	}

	@Override
	public JSONObject getJsonObjectFromArray(JSONArray jsonArray, int index) {
		JSONObject jsonObject = null;
		try {
			jsonObject = jsonArray.getJSONObject(index);
		} catch (JSONException e) {
			MZLog.e(getClass().getSimpleName(), Log.getStackTraceString(e));
		}
		return jsonObject;
	}

}
