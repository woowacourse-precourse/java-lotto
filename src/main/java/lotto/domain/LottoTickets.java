package lotto.domain;

import java.util.List;

public class LottoTickets {
	private List<LottoTicket> lottoTickets;
	public LottoTickets(String purchasingAmount) {
		if (!isValidPurchasingAmount(purchasingAmount)) {
			throw new IllegalArgumentException();
		}
		purchaseLottoTickets(toInt(purchasingAmount));

	}

	private void purchaseLottoTickets(int purchasingAmount) {
		while (purchasingAmount != 0) {
			lottoTickets.add(new LottoTicket(LottoNumberGenerator.generate()));
			purchasingAmount -= 1000;
		}
	}

	private boolean isValidPurchasingAmount(String purchasingAmount) {
		return true;
	}

	private int toInt(String str) {
		return Integer.valueOf(str);
	}
}
