package system;

import java.io.File;
import java.util.ArrayList;

import string.StringTools;

public class FileUtils {

	public static Object deepCopy(Object o) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * getListFiles
	 * @param nameDir
	 * @return
	 */
	public static ArrayList<File> getListFiles(String nameDir) {

		if(StringTools.isEmptyString(nameDir)) return null;

		File dir = new File(nameDir);
		ArrayList<File> resultat = new ArrayList<File>();

		for(File file : dir.listFiles()) {
			resultat.add(file);
		}
			
		return resultat;
	}
}
