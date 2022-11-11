package lotto;

import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
	public HashSet<Integer> lottery() {
		HashSet<Integer> lotteryTicket = new HashSet<>();
		while (lotteryTicket.size() < 6) {
			int randomNum = Randoms.pickNumberInRange(1, 45);
			lotteryTicket.add(randomNum);
		}
		return lotteryTicket;
	}

	public List<Integer> sortNumber(HashSet<Integer> randomLottoNumber) {
		return null;
	}
}
