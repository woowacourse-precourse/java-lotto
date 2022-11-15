package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class EarningsRate {
	private final static int MONEY_UNIT = 1000;
	BigDecimal earningsRate;

	public EarningsRate(Map<LottoType, Integer> stat, List<LottoTicket> lottoTickets) {
		int prizeMoney = calculatePrizeMoney(stat);
		int purchaseAmount = lottoTickets.size() * MONEY_UNIT;
		earningsRate = new BigDecimal(String.valueOf((double)prizeMoney / purchaseAmount));
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
