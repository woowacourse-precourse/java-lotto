package lotto.controller;

import static lotto.utils.ErrorMessage.*;
import static lotto.utils.TypeConversion.*;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersGenerator {

	public static List<Integer> generate(String lottoNumbers) {
		validate(lottoNumbers);
		List<String> nums = stringsToList(lottoNumbers.split(","));
		return stringListToIntegerList(nums);
	}

	private static void validate(String lottoNumbers) {
		if (!isConsistValidCharacters(lottoNumbers)) {
			throw new IllegalArgumentException(INPUT_ONLY_NUMBER.getMessage());
		}
	}

	private static boolean isConsistValidCharacters(String lottoNumbers) {
		return lottoNumbers.matches("^[0-9,]+$");
	}
}
