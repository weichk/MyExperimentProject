package com.eabax.test;

import org.json.JSONException;
import org.json.JSONObject;

public class TestJson {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("ID", 0);
			long parentId = 0;
			if (obj.has("ID")) {
				String str = obj.valueToString(obj.get("ID"));
				long reReSult = 0;
				if (str != null && !"".equals(str)) {
					reReSult = Long.parseLong(str);
				}
				parentId = reReSult;
				System.out.println(parentId);
			}
		} catch (JSONException e) {
			System.out.println("sasd");
			e.printStackTrace();
		}
	}
}
