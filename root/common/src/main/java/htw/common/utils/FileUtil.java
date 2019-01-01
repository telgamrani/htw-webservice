package htw.common.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;

public class FileUtil {

	public static boolean saveFile(String dataFile, String directory, String fileName, String fileExtension) {
		boolean isOk = false;
		try {
        	byte[] imageByte = Base64.decodeBase64(Base64Util.removeMetaDataFromBase64Data(dataFile));
        	String path = "D:/"+directory+"/"+fileName+"."+fileExtension;
        	FileOutputStream fos = new FileOutputStream(path);
        	fos.write(imageByte);
        	fos.close();
        	isOk = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return isOk;
	}
}
