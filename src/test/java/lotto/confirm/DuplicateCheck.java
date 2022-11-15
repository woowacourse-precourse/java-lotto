package confirm;

public class DuplicateCheck {
	public static void run(int i) {
		if(i>1) {
			 throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
		}
	}
}
