package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.player.PurchaseCount;
import lotto.domain.util.Rule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

	public List<Lotto>  issueLotto(PurchaseCount purchaseCount) {
		List<Lotto> lottoTickets = new ArrayList<>();

		for (int i = 0; i < purchaseCount.toLotto(); i++) {
			Lotto lotto = new Lotto(generateLottoNumbers());
			lottoTickets.add(lotto);
		}

		return lottoTickets;
	}

	private List<Integer> generateLottoNumbers() {
		return sortNumbers(Randoms.pickUniqueNumbersInRange(Rule.LOTTO_FIRST_NUMBER_INCLUSIVE.getValue(), Rule.LOTTO_LAST_NUMBER_INCLUSIVE.getValue(), Rule.LOTTO_NUMBER_DIGITS.getValue()));
	}

	private List<Integer> sortNumbers(List<Integer> numbers) {
		if (!isSortedAsc(numbers)) {    // 테스트로 설정된 List가 UnmodifiableList이면서 오름차순이기 때문에 이와 같은 수행을 더해준다
			numbers.sort(Comparator.naturalOrder());
		}
		return numbers;
	}

	private boolean isSortedAsc(List<Integer> numbers) {
		return numbers.stream().sorted().collect(Collectors.toList()).equals(numbers);
	}
}
