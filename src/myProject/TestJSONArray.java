package myProject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJSONArray {
	public static void main(String[] args) throws JSONException {
		JSONArray array = new JSONArray();
		JSONObject o = new JSONObject();
		o.put("a", 0);
		array.put(o);
		aaa(array);
		for (int i = 0; i < array.length(); i++) {
			JSONObject o1 = array.getJSONObject(i);
			System.err.println(o1.get("a"));
		}
	}
	public static void aaa(JSONArray A) throws JSONException {
		for (int i = 0; i < A.length(); i++) {
			JSONObject o = A.getJSONObject(i);
			o.put("a", 1);
		}
	}
}
