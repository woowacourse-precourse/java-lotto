package confirm;

public class overflowCheck {
	public static void run(int i) {
		if(i>45 || i<1) {
			 throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
		}
	}
}
