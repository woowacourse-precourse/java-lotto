package lotto.domain.lotto;

import java.util.List;

public class LottoTickets {
	private final List<Lotto> lottoTickets;

	private LottoTickets(List<Lotto> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public static LottoTickets setsOf(List<Lotto> lottoTickets) {
		return new LottoTickets(lottoTickets);
	}

	public List<Lotto> getLottoTickets() {
		return lottoTickets;
	}
}
