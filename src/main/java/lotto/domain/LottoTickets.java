package lotto.domain;

import static lotto.domain.LottoTicketsValidator.*;
import static lotto.utils.Integer.*;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
	public final static int MONEY_UNIT = 1000;
	private List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(String purchasingAmount) {
		checkValidityAndThrowException(purchasingAmount);
		purchaseLottoTickets(toInt(purchasingAmount));
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	private void purchaseLottoTickets(int purchasingAmount) {
		while (purchasingAmount != 0) {
			lottoTickets.add(new LottoTicket(LottoNumberGenerator.generate()));
			purchasingAmount -= MONEY_UNIT;
		}
	}
}
