package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lottoConstant.Constant;

public class LottoTicket {
	private final List<Lotto> lottoTickets = new ArrayList<>();

	public LottoTicket(int ticketNumber) {
		createLottoTickets(ticketNumber);
	}

	private void createLottoTickets(int ticketNumber) {
		for (int i = 0; i < ticketNumber; i++) {
			List<Integer> lottoNumber = new ArrayList<>(
				Randoms.pickUniqueNumbersInRange(Constant.MIN_VALUE, Constant.MAX_VALUE, Constant.LOTTO_SIZE));
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
