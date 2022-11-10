package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	static final String NUMBER_DELIMITER = ",";

	public static String[] getLottoNumbers() {
		String[] pickNumbers = Console.readLine().split(NUMBER_DELIMITER);
		return pickNumbers;
	}

	public static List<Integer> convertIntoIntegerList(String[] strings) {
		return Arrays.stream(strings).
			map(string -> Integer.parseInt(string)).
			collect(Collectors.toList());
	}

}
