package myProject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class TestServlet {
	/**
	 * @param args
	 */
	private static String URL = "http://222.177.9.14:9090/plugins/yundada/getinfotypelist";

	public static void main(String[] args) throws JSONException {

		// Post Data 为Form提交的内容。
		JSONObject obj = new JSONObject();
		obj.put("authtoken", "f3679f46-a8cc-4125-8362-d89f4472d132");
		obj.put("timestamp", "0000");
		String postData = obj.toString();
		String html = GetResponseDataByID(URL, postData);
		JSONObject var = new JSONObject(html);
		System.out.println(var.toString());
	}

	public static void PrintStrs(String[] str) {
		for (String s : str) {
			System.out.print(s + ",");
		}
		System.out.println();
	}

	public static String GetResponseDataByID(String url, String postData) {
		String data = null;
		try {
			URL dataUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) dataUrl
					.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Proxy-Connection", "Keep-Alive");
			con.setDoOutput(true);
			con.setDoInput(true);

			OutputStream os = con.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.write(postData.getBytes());
			dos.flush();
			dos.close();

			InputStream is = con.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte d[] = new byte[dis.available()];
			dis.read(d);
			data = new String(d);
			con.disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}
}