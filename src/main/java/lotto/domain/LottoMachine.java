package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int LOTTO_NUMBERS_SIZE = 6;

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
			List<Integer> numbers = new ArrayList<>(
				Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_SIZE));
			Collections.sort(numbers);
			list.add(new Lotto(numbers));
		}
		return list;
	}

}
