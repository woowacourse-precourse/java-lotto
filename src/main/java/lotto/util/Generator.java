package lotto.util;

import static lotto.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.Lotto;

public class Generator {
	public Lotto createLottery() {
		List<Integer> lotteryTicket = new ArrayList<>(
			Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_SIZE));
		return sortNumber(lotteryTicket);
	}

	private Lotto sortNumber(List<Integer> randomNumbers) {
		List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
		sortedNumbers.sort(null);
		return new Lotto(sortedNumbers);
	}
}
