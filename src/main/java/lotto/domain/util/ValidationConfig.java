package lotto.domain.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.*;
import static lotto.domain.util.Rule.*;

public class ValidationConfig {
	private static final String NUMBER_ONLY_REGEX = "^\\d+$"; // 숫자로만 구성된 형식을 표현한다
	private static final String NUMBER_INPUT_FORMAT_REGEX = "^([a-z0-9]+,)+[a-z0-9]+$"; // "<시작문자><쉼표><종료문자>" 형식을 표현한다
	private static final String NUMBER_INPUT_COUNT_REGEX = "^([a-z0-9]+,){5}([a-z0-9]+)$"; // "(<시작문자><쉼표>)X5<종료문자>" 형식을 표현한다
	private static final String NUMBER_IN_BETWEEN_1_AND_45 = "(^[1-9]$|^[1-3][0-9]$|^4[0-5]$)"; // "1~45" 숫자 형식을 표현한다
	private static final String BONUS_NUMBER_INPUT_COUNT_REGEX = "^([a-z0-9]+)$"; // 1개의 문자 형식을 표현한다

	protected static boolean isInputEmpty(String input){
		return input.isEmpty();
	}

	public static boolean isNotANumber(String input) {
		return !input.matches(NUMBER_ONLY_REGEX);
	}

	public static boolean isLessThanMinimumAmount(String input) {
		long amount = parseInt(input);
		return amount < LOTTO_PRICE.getMoney();
	}

	public static boolean isAssignedCurrencyUnit(String input) {
		long amount = parseInt(input);
		return amount % LOTTO_PRICE.getMoney() == 0;
	}

	public static boolean isWinningNumberCorrectlyFormatted(String input) {
		return input.matches(NUMBER_INPUT_FORMAT_REGEX);
	}

	public static boolean isWinningNumberCountCorrectlyProvided(String input) {
		return input.matches(NUMBER_INPUT_COUNT_REGEX);
	}

	public static boolean isWinningNumberCorrectlyRanged(String input) {
		Stream<Integer> numbers = toStreamInteger(input);
		return numbers.allMatch(number -> number >= LOTTO_FIRST_NUMBER_INCLUSIVE.getValue()
				&& number <= LOTTO_LAST_NUMBER_INCLUSIVE.getValue());
	}

	public static boolean isWinningNumberDuplicateExists(String input) {
		return toStreamInteger(input).distinct().count() != toStreamInteger(input).count();    // 스트림 객체의 개별 소환을 위해 각각 호출한다
	}

	public static boolean isBonusNumberCorrectlyRanged(String input) {
		return input.matches(NUMBER_IN_BETWEEN_1_AND_45);
	}

	public static boolean isBonusNumberCountCorrectlyProvided(String input) {
		return input.matches(BONUS_NUMBER_INPUT_COUNT_REGEX);
	}

	public static boolean isBonusNumberDuplicateExists(String bonusInput, List<Integer> winningNumber) {
		return winningNumber.contains(Integer.parseInt(bonusInput));
	}

	protected static boolean isLottoNumberDuplicateExists(List<Integer> numbers) {
		Set<Integer> checkDuplicate = new HashSet<>(numbers);
		checkDuplicate.retainAll(numbers);
		return checkDuplicate.size() != Rule.LOTTO_NUMBER_DIGITS.getValue();
	}

	private static Stream<Integer> toStreamInteger(String input) {
		return Pattern.compile(",").
				splitAsStream(input).
				map(Integer::parseInt);
	}
}


