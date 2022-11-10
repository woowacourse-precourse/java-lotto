package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
	private List<LottoTicket> lottoTickets = new ArrayList<>();
	public LottoTickets(String purchasingAmount) {
		if (!isValidPurchasingAmount(purchasingAmount)) {
			throw new IllegalArgumentException();
		}
		purchaseLottoTickets(toInt(purchasingAmount));

	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
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
