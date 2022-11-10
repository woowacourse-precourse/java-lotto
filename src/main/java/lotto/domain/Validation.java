package lotto.domain;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.*;
import static lotto.Setup.*;

public class Validation {
	private static final String NUMBER_ONLY_REGEX = "^\\d+$";
	private static final String NUMBER_INPUT_FORMAT_REGEX = "^(.+,)+.+$"; // "<시작문자><쉼표><종료문자>" 형식을 표현한다
	private static final String NUMBER_INPUT_COUNT_REGEX = "^(.+,){5}.+$"; // "(<시작문자><쉼표>)X5<종료문자>" 형식을 표현한다

	public static boolean isNotANumber(String input) {
		return !input.matches(NUMBER_ONLY_REGEX);
	}

	public static boolean isAssignedCurrencyUnit(String input) {
		long amount = parseInt(input);
		return amount % LOTTO_PRICE.getValue() == 0;
	}

	public static boolean isLessThan1000(String input) {
		long amount = parseInt(input);
		return amount < LOTTO_PRICE.getValue();
	}

	public static boolean isCorrectlyFormatted(String input) {
		return input.matches(NUMBER_INPUT_FORMAT_REGEX);
	}

	public static boolean isCountCorrectlyProvided(String input) {
		return input.matches(NUMBER_INPUT_COUNT_REGEX);
	}

	public static boolean isCorrectlyRanged(String input) {
		Stream<Integer> numbers = getNumbers(input);
		return numbers.allMatch(number -> number >= LOTTO_FIRST_NUMBER_INCLUSIVE.getValue()
				&& number <= LOTTO_LAST_NUMBER_INCLUSIVE.getValue());
	}

	public static boolean isDuplicateExists(String input) {
		return getNumbers(input).distinct().count() != getNumbers(input).count();	// 스트림 객체의 개별 소환을 위해 각각 호출한다
	}

	private static Stream<Integer> getNumbers(String input) {
		return Pattern.compile(",").
				splitAsStream(input).
				map(Integer::parseInt);
	}
}


