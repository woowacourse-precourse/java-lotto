package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	private final List<Lotto> lottoTickets;

	public LottoMachine(int getNumberOfTickets) {
		List<Lotto> newLottoTickets = publishLottoTickets(getNumberOfTickets);
		this.lottoTickets = new ArrayList<>(newLottoTickets);
	}

	public List<Lotto> getLottoTickets() {
		return Collections.unmodifiableList(lottoTickets);
	}

	private List<Lotto> publishLottoTickets(int getNumberOfTickets) {
		List<Lotto> list = new ArrayList<>();
		for (int i = 0; i < getNumberOfTickets; i++) {
			list.add(new Lotto(createLottoNumbers()));
		}
		return list;
	}

	private List<Integer> createLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(
			Number.MIN.getValue(),
			Number.MAX.getValue(),
			Number.SIZE.getValue()
		);
	}

}
