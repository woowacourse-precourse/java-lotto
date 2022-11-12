package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicketNumberGenerator {

	public static List<Integer> generate() {
		return Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

}
