package lotto.domain.model;

import java.util.List;

public class LottoTicket {
	private final List<List<Integer>> ticket;

	public LottoTicket(List<List<Integer>> ticket){
		validate(ticket);
		this.ticket = ticket;
	}

	private void validate(List<List<Integer>> ticket) {
		for (List<Integer> numbers : ticket){
			if (numbers.size() != 6)
				throw new IllegalArgumentException();
		}
	}

	public List<List<Integer>> getTicket() {
		return ticket;
	}
}
