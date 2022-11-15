package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	public static int requestInputMoney() {
		System.out.println("구입금액을 입력해주세요.");
		return convertStringToInt(Console.readLine());
	}

	public static List<Integer> requestInputWinningNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		return convertStringToIntList(Console.readLine());
	}

	public static int requestInputBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		return convertStringToInt(Console.readLine());
	}

	private static List<Integer> convertStringToIntList(String input) {
		validate(input);
		return Arrays
				.stream(input.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static int convertStringToInt(String input) {
		validate(input);
		return Integer.parseInt(input);
	}

	private static void validate(String input) {
		if (input.trim().isEmpty() || input == null) {
			throw new IllegalArgumentException("[ERROR] 공백은 사용할 수 없습니다.");
		}

		if (!input.chars().allMatch(Character::isDigit) && !input.contains(",")) {
			throw new IllegalArgumentException("[ERROR] 숫자와 콤마만 입력 가능합니다.");
		}
	}
}
