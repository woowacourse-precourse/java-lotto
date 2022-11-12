package lotto.domain;

import static lotto.domain.LottoTicketsValidator.*;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersGenerator {

	public static List<Integer> generate(String lottoNumbers) {
		validate(lottoNumbers);
		String[] numbers = lottoNumbers.split(",");
		List<String> nums = stringsToList(numbers);
		return stringListToIntegerList(nums);
	}

	private static List<Integer> stringListToIntegerList(List<String> strings) {
		List<Integer> integers = new ArrayList<>();
		for (String string : strings) {
			integers.add(Integer.valueOf(string));
		}
		return integers;
	}

	private static List<String> stringsToList(String[] strings) {
		List<String> list = new ArrayList<>();
		for (String string : strings) {
			list.add(string);
		}
		return list;
	}

	private static void validate(String lottoNumbers) {
		if (!isConsistValidCharacters(lottoNumbers)) {
			throw new IllegalArgumentException(ERROR + "올바른 문자를 입력해주세요.");
		}
	}

	private static boolean isConsistValidCharacters(String lottoNumbers) {
		return lottoNumbers.matches("^[0-9,]+$");
	}
}
