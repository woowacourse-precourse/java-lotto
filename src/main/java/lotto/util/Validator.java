package lotto.util;

public class Validator {
	public static void validateIntegerOrNot(String input) {
		if (input.chars().anyMatch(letter -> letter < '0' || letter > '9')) {
			throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
		}
	}
}
