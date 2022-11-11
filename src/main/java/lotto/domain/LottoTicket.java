package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
	private final int MIN_LOTTO_NUMBER = 1;
	private final int MAX_LOTTO_NUMBER = 45;
	private final int LOTTO_NUMBER_LENGTH = 6;
	private List<Lotto> ticket;

	public LottoTicket(int numberOfLotto) {
		this.ticket = createLottoTicket(numberOfLotto);
	}

	private List<Lotto> createLottoTicket(int NumberOfLotto) {
		List<Lotto> lottoTicket = new ArrayList<>();
		int createNumber = 0;
		while (createNumber++ < NumberOfLotto) {
			Lotto lotto = new Lotto(createLottoNumbers());
			lottoTicket.add(lotto);
		}
		return lottoTicket;
	}

	private List<Integer> createLottoNumbers() {
		List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
			LOTTO_NUMBER_LENGTH);
		return lottoNumbers;
	}

	public List<Lotto> getTicket() {
		return this.ticket;
	}
}
