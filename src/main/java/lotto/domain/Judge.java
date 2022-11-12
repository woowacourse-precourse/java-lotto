package lotto.domain;

import java.util.List;

import lotto.utils.LottoType;

public class Judge {
	public static LottoType getPrize(Lotto lotto, LottoBonus lottoBonus, LottoTicket lottoTicket) {
		LottoType prize = getGrade(lotto.getNumbers(), lottoBonus.getBonusNumber(), lottoTicket.getNumbers());
		return prize;
	}

	private static LottoType getGrade(List<Integer> lotto, int lottoBonus, List<Integer> lottoTicket) {
		int cnt = 0;
		for (int number : lottoTicket) {
			if (lotto.contains(number)) {
				cnt++;
			}
		}
		if (cnt == 6) {
			return LottoType.FIRST;
		}
		if (cnt == 5) {
			if (lottoTicket.contains(lottoBonus)) {
				return LottoType.SECOND;
			}
			return LottoType.THIRD;
		}
		if (cnt == 4) {
			return LottoType.FOURTH;
		}
		if (cnt == 3) {
			return LottoType.FIFTH;
		}
		return null;
	}
}
