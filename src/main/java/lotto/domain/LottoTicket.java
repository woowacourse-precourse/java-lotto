package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
	private final int ticketNumber;

	public LottoTicket(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public List<List<Integer>> createLottoTickets() {
		List<List<Integer>> lottoTickets = new ArrayList<>();
		for (int i = 0; i < ticketNumber; i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			lottoTickets.add(lotto.getNumbers());
		}
		return lottoTickets;
	}
}
