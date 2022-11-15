package lotto.ui;

import static lotto.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

import lotto.ErrorMessage;

public class Reader {

	public static Integer readPurchaseAmount() {
		try {
			return Integer.valueOf(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

	public static List<Integer> readWinningNumbers() {
		try {
			return Arrays.stream(Console.readLine()
							.split(COMMA))
					.map(Integer::valueOf)
					.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

	public static Integer readBonusNumber() {
		try {
			return Integer.valueOf(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
		}
	}

}
