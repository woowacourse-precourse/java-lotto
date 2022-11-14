package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
	public static long convertStringOfMoneyToLong(String stringOfMoney) {
		StringBuilder stringBuilder = new StringBuilder();
		stringOfMoney.chars().forEach(letter -> {
			if (letter >= '0' && letter <= '9') {
				stringBuilder.append((char)letter);
			}
		});
		return Long.parseLong(stringBuilder.toString());
	}

	public static List<Integer> convertStringWithCommaToIntegerList(String string) {
		return Arrays.stream(string.split(","))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());
	}
}
