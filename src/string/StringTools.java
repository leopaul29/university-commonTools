package string;

public class StringTools {

	/**
	 * isEmptyString
	 * @param str
	 * @return true, if string is null or empty
	 */
	public static boolean isEmptyString(String str) {

		// Check not null and no space
		return str == null || str.trim().length() == 0;
	}
}
