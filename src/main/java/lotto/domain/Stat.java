package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.utils.LottoType;

public class Stat {
	private Map<LottoType, Integer> stat = new HashMap<>();

	public Stat(Lotto lotto, LottoBonus lottoBonus, LottoTickets lottoTickets) {
		initStat();
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			int lottoNumber = countLottoNumber(lotto.getNumbers(), lottoTicket.getNumbers());
			int bonusNumber = countBonusNumber(lottoBonus.getBonusNumber(), lottoTicket.getNumbers());
			setStat(LottoType.getType(lottoNumber, bonusNumber));
		}
	}

	private void initStat() {
		for (LottoType lottoType : LottoType.values()) {
			stat.put(lottoType, 0);
		}
	}

	private void setStat(LottoType lottoType) {
		if (stat.containsKey(lottoType)) {
			stat.put(lottoType, stat.get(lottoType) + 1);
		}
	}

	private int countBonusNumber(int lottoBonus, List<Integer> lottoTicket) {
		int bonusNumber = 0;
		if (lottoTicket.contains(lottoBonus)) {
			bonusNumber = 1;
		}
		return bonusNumber;
	}

	private int countLottoNumber(List<Integer> lotto, List<Integer> lottoTicket) {
		int lottoNumber = 0;
		for (int number : lottoTicket) {
			if (lotto.contains(number)) {
				lottoNumber++;
			}
		}
		return lottoNumber;
	}

	public Map<LottoType, Integer> getStat() {
		return stat;
	}
}
