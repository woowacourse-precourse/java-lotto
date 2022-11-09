package lotto;

public class ExceptionHandler {

	public static void checkMoney(int money) {
		if ((money % 1000) != 0)
			throw new IllegalArgumentException("ERROR");
	}
}
