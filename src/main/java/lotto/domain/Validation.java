package lotto.domain;

import java.util.stream.Stream;

import static java.lang.Integer.*;
import static lotto.Setup.*;
import static lotto.domain.Player.*;

public class Validation {
	private static final String NUMBER_ONLY_REGEX = "^\\d+$"; // 숫자로만 구성된 형식을 표현한다
	private static final String NUMBER_INPUT_FORMAT_REGEX = "^(.+,)+.+$"; // "<시작문자><쉼표><종료문자>" 형식을 표현한다
	private static final String NUMBER_INPUT_COUNT_REGEX = "^(.+,){5}.+$"; // "(<시작문자><쉼표>)X5<종료문자>" 형식을 표현한다
	private static final String NUMBER_IN_BETWEEN_1_AND_45 = "(^[1-9]$|^[1-3][0-9]$|^4[0-5]$)"; // "1~45" 숫자 형식을 표현한다
	private static final String BONUS_NUMBER_INPUT_COUNT_REGEX = "^(.+)$"; // 1개의 문자 형식을 표현한다

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

	public static boolean isLottoNumberCorrectlyFormatted(String input) {
		return input.matches(NUMBER_INPUT_FORMAT_REGEX);
	}

	public static boolean isLottoNumberCountCorrectlyProvided(String input) {
		return input.matches(NUMBER_INPUT_COUNT_REGEX);
	}

	public static boolean isLottoNumberCorrectlyRanged(String input) {
		Stream<Integer> numbers = getNumbers(input);
		return numbers.allMatch(number -> number >= LOTTO_FIRST_NUMBER_INCLUSIVE.getValue()
				&& number <= LOTTO_LAST_NUMBER_INCLUSIVE.getValue());
	}

	public static boolean isLottoNumberDuplicateExists(String input) {
		return getNumbers(input).distinct().count() != getNumbers(input).count();    // 스트림 객체의 개별 소환을 위해 각각 호출한다
	}

	public static boolean isBonusNumberCorrectlyRanged(String input) {
		return input.matches(NUMBER_IN_BETWEEN_1_AND_45);
	}

	public static boolean isBonusNumberCountCorrectlyProvided(String input) {
		return input.matches(BONUS_NUMBER_INPUT_COUNT_REGEX);
	}

	public static boolean isBonusNumberDuplicateExists(String input, Stream lottoNumbers) {
		return lottoNumbers.anyMatch(lottoNumber -> lottoNumber.equals(Integer.parseInt(input)));
	}
}


