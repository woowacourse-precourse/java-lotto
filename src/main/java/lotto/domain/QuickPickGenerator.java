package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class QuickPickGenerator {
	public static List<Lotto> quickPick(int count) {
		List<Lotto> lotteries = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}

		return lotteries;
	}
}
