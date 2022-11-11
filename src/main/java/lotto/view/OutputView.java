package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;

public class OutputView {
	private static final String BUY_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";

	public static void printLottos(List<Lotto> lottos) {
		System.out.printf(BUY_LOTTO_MESSAGE, lottos.size());
		for (Lotto lotto : lottos) {
			printLotto(lotto);
		}
	}

	private static void printLotto(Lotto lotto) {
		System.out.print("[");
		System.out.print(String.join(", ", convertToStringList(lotto.getNumbers())));
		System.out.println("]");
	}

	private static List<String> convertToStringList(List<Integer> numbers) {
		return numbers.stream()
			.sorted()
			.map(number -> Integer.toString(number))
			.collect(Collectors.toList());
	}

	public static void printError(ErrorMessage error) {
		System.out.println(error.getMessage());
	}
}
