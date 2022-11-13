package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
	public static List<Integer> convertStringWithCommaToIntegerList(String string) {
		return Arrays.stream(string.split(","))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());
	}
}
