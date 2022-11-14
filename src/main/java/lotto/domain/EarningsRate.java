package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import lotto.utils.LottoType;

public class EarningsRate {
	BigDecimal earningsRate;
	public EarningsRate(Map<LottoType, Integer> stat, List<LottoTicket> lottoTickets) {
		int prizeMoney = calculatePrizeMoney(stat);
		int purchaseAmount = lottoTickets.size() * 1000;
		earningsRate = new BigDecimal((double)prizeMoney / purchaseAmount);
	}

	private int calculatePrizeMoney(Map<LottoType, Integer> stat) {
		int prizeMoney = 0;
		for (LottoType lottoType : LottoType.values()) {
			prizeMoney = prizeMoney + lottoType.getMoney() * stat.get(lottoType);
		}
		return prizeMoney;
	}

	public BigDecimal getEarningsRate() {
		return this.earningsRate;
	}
}
