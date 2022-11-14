package util;

public class ExceptionUtil {

	public static void makeException(String errComment) {
	
		
		try {
			throw new IllegalArgumentException();
		}finally {
			System.out.println("[ERROR]"+errComment);
			System.exit(0);
		}
		
	
	}

}
