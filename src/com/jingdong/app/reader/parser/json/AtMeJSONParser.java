package com.jingdong.app.reader.parser.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.jingdong.app.reader.timeline.model.core.Entity;
import com.jingdong.app.reader.util.MZLog;

public class AtMeJSONParser implements JSONParser {
	private static final String AT_ME = "at_users";

	@Override
	public JSONArray getJsonArrayFromString(String jsonString) {
		JSONArray jsonArray = null;
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(jsonString);
			jsonArray = jsonObject.getJSONArray(AT_ME);
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
			long id = jsonObject.getLong(Entity.ID);
			jsonObject = jsonObject.getJSONObject(CommentJsonParser.ENTITY);
			jsonObject.put(Entity.ID, id);
		} catch (JSONException e) {
			MZLog.e(getClass().getSimpleName(), Log.getStackTraceString(e));
		}
		return jsonObject;
	}

}
