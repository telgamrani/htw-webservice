package htw.common.utils;

import java.util.regex.Pattern;

public class Base64Util {

	private static Pattern pattern = Pattern.compile("^data:image\\/[a-z]+;base64,", Pattern.CASE_INSENSITIVE);
	
	public static String removeMetaDataFromBase64Data(String data) {
		return pattern.matcher(data).replaceAll("");
	}
	
	public static String getExtension(String data) {
		if(data == null) {
			return null;
		}
		
		String extension = null;
		String result = pattern.matcher(data).replaceAll("");
		String dataResult = data.replace(result, "");
		if(dataResult != null) {
			if(dataResult.toLowerCase().contains("jpg")) {
				extension = "jpg";
			}
			if(dataResult.toLowerCase().contains("jpeg")) {
				extension = "jpeg";
			}
			if(dataResult.toLowerCase().contains("png")) {
				extension = "png";
			}
			if(dataResult.toLowerCase().contains("gif")) {
				extension = "gif";
			}
			if(dataResult.toLowerCase().contains("bmp")) {
				extension = "bmp";
			}
		}
		return extension;
	}
}
