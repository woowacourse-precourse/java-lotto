package lotto;

public class StringValidator {

	public void checkIsNumber(String string) {
		if (!string.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
		}
	}

}
