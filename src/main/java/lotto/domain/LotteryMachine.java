package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;

public class LotteryMachine {

	public static Lotto autoGenerate() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return new Lotto(numbers);
	}

	public static List<Lotto> autoGenerate(int lottoCount) {
		List<Lotto> lottos = new LinkedList<>();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(autoGenerate());
		}
		return lottos;
	}
}
