package lotto.domain;

import java.util.List;
import java.util.Map;

import lotto.utils.LottoType;

public class EarningsRate {
	double earningsRate;
	public EarningsRate(Map<LottoType, Integer> stat, List<LottoTicket> lottoTickets) {
		int prizeMoney = calculatePrizeMoney(stat);
		int purchaseAmount = lottoTickets.size() * 1000;
		this.earningsRate = (double)prizeMoney / purchaseAmount * 100;
	}

	private int calculatePrizeMoney(Map<LottoType, Integer> stat) {
		int prizeMoney = 0;
		for (LottoType lottoType : LottoType.values()) {
			prizeMoney = prizeMoney + lottoType.getMoney() * stat.get(lottoType);
		}
		return prizeMoney;
	}

	public double getEarningsRate() {
		return this.earningsRate;
	}
}
