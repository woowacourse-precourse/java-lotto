package lotto.domain.model;

import java.util.List;

public class LottoTicket {
	private final List<List<Integer>> lottoTicket;

	public LottoTicket(List<List<Integer>> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	public List<List<Integer>> getLottoTicket() {
		return lottoTicket;
	}
}
