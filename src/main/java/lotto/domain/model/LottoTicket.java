package lotto.domain.model;

import java.util.List;

public class LottoTicket {
	private final List<List<Integer>> lottoTicket;

	public LottoTicket(List<List<Integer>> lottoTicket){
		validate(lottoTicket);
		this.lottoTicket = lottoTicket;
	}

	private void validate(List<List<Integer>> lottoTicket) {
		for (List<Integer> numbers : lottoTicket){
			if (numbers.size() != 6)
				throw new IllegalArgumentException();
		}
	}

	public List<List<Integer>> getLottoTicket() {
		return lottoTicket;
	}
}
