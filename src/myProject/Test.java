package myProject;

import java.util.Map;

public class Test {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 去掉空格的情况
	 * @param dataRow
	 * @return
	 */
	public static boolean cleanSpace(Map<String, String> dataRow) {
		boolean reResult = false;
		for(Map.Entry<String, String> entry: dataRow.entrySet()) {
			String value = entry.getValue();
			if(value != null) {
				value = value.trim();
			}
			if(value!=null && !"".equals(value)) {
				reResult = true;
			}
		}
//		log.error(reResult+"");
		return reResult;
	}
}
