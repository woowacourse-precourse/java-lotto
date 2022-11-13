package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
	private final List<List<Integer>> lottoTickets = new ArrayList<>();

	public LottoTicket(int ticketNumber) {
		createLottoTickets(ticketNumber);
	}

	private void createLottoTickets(int ticketNumber) {
		for (int i = 0; i < ticketNumber; i++) {
			List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			Collections.sort(lottoNumber);
			Lotto lotto = new Lotto(lottoNumber);
			lottoTickets.add(lotto.getNumbers());
		}
	}

	public List<List<Integer>> getLottoTickets() {
		return lottoTickets;
	}
}
