package lotto.controller;

import static lotto.utils.ErrorMessage.*;
import static lotto.utils.TypeConversion.*;

import java.util.List;

public class LottoNumbersGenerator {

	public static List<Integer> generate(String lottoNumbers) {
		validate(lottoNumbers);
		List<String> nums = stringsToList(lottoNumbers.split(","));
		return stringListToIntegerList(nums);
	}

	private static void validate(String lottoNumbers) {
		if (!isConsistValidCharacters(lottoNumbers)) {
			throw new IllegalArgumentException(INPUT_NUMBER_AND_COMMA_ONLY.getMessage());
		}
	}

	private static boolean isConsistValidCharacters(String lottoNumbers) {
		return lottoNumbers.matches("^[0-9,]+$");
	}
}
