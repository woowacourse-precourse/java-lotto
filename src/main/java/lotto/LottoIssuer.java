package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.ui.ConsoleOutput.*;

public class LottoIssuer {

	private static int purchasedLotto;
	public static List<List<Integer>> issuedLottoes = new ArrayList<>();

	public LottoIssuer(long totalAmount) {
		countLotto(totalAmount);
		issueLotto();
	}

	private void countLotto(long totalAmount) {
		int purchasedLotto = Math.toIntExact(totalAmount) / Setup.LOTTO_PRICE.getValue();
		PrintNotificationMessage(purchasedLotto);
		LottoIssuer.purchasedLotto = purchasedLotto;
	}

	private static void issueLotto() {
		for (int i = 0; i < purchasedLotto; i++) {
			Lotto lotto = new Lotto(generateLottoNumbers());
			issuedLottoes.add(lotto.getNumbers());
		}
	}

	private static List<Integer> generateLottoNumbers() {
		return  sortNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
	}

	private static List<Integer> sortNumbers(List<Integer> numbers) {
		if (!isSortedAsc(numbers)) {	// 테스트로 설정된 List가 UnmodifiableList이면서 오름차순이기 때문에 이와 같은 수행을 더해준다
			numbers.sort(Comparator.naturalOrder());
		}
		return numbers;
	}

	private static boolean isSortedAsc(List<Integer> numbers) {
		return numbers.stream().sorted().collect(Collectors.toList()).equals(numbers);
	}
}
