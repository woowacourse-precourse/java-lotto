package util;

public class ExceptionUtil {

	public static void makeException(String errComment) {
		System.err.println("[ERROR]"+errComment);
		throw new IllegalArgumentException();
	}

}
