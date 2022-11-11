package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Buyer {
	private static final int ZERO_COUNT = 0;

	private final int amount;
	private final List<Lotto> lottos;

	public Buyer(String inputAmount) {
		amount = Integer.parseInt(inputAmount);
		lottos = new ArrayList<>();
		buyLotto();
	}

	private List<Integer> generateLottoNumber() {
		return Randoms.pickUniqueNumbersInRange(ConstValue.MIN_LOTTO_NUMBER,
			ConstValue.MAX_LOTTO_NUMBER, ConstValue.LOTTO_NUMBERS);
	}

	private List<Integer> sortNumbers(List<Integer> lottoNumbers) {
		return lottoNumbers.stream()
			.sorted()
			.collect(Collectors.toList());
	}

	private void buyLotto() {
		for (int i = ZERO_COUNT; i < lottoCount(); i++) {
			List<Integer> lottoNumbers = generateLottoNumber();
			lottos.add(new Lotto(sortNumbers(lottoNumbers)));
		}

	}

	private int lottoCount() {
		return amount / ConstValue.LOTTO_PRICE;
	}

	public List<Lotto> getLotto() {
		return lottos;
	}

	public double getAmount() {
		return amount;
	}
}
