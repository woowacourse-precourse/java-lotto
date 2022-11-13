package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 45;
	private static final int LOTTO_COUNT = 6;
	private final List<Lotto> lottoTickets = new ArrayList<>();

	public LottoTicket(int ticketNumber) {
		createLottoTickets(ticketNumber);
	}

	private void createLottoTickets(int ticketNumber) {
		for (int i = 0; i < ticketNumber; i++) {
			List<Integer> lottoNumber = new ArrayList<>(
				Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_COUNT));
			Collections.sort(lottoNumber);
			Lotto lotto = new Lotto(lottoNumber);
			lottoTickets.add(lotto);
		}
	}

	public LottoResult calculateRank(WinningNumber winningNumber, BonusNumber bonusNumber) {
		List<LottoRanking> rank = lottoTickets.stream()
			.map(lotto -> winningNumber.calculateMatchCount(lotto, bonusNumber.getBonusNumber()))
			.collect(Collectors.toUnmodifiableList());
		return new LottoResult(rank);
	}

	public List<Lotto> getLottoTickets() {
		return lottoTickets;
	}
}
