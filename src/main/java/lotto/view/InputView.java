package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

	public static int getPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		return getNumber();
	}

	public static int getBonusNumber() {
		System.out.println("\n보너스 번호를 입력해 주세요.");
		return getNumber();
	}

	public static int getNumber() {
		String input = readLine();
		return Integer.parseInt(input);
	}

	public static List<Integer> getNumbers() {
		System.out.println("\n당첨번호를 입력해 주세요.");
		return Arrays.stream(readLine().split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
