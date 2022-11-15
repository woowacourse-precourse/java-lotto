package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count {
	public final static String LOTTO = "lotto";
	public final static String BONUS = "bonus";
	private List<Map<String, Integer>> count;

	public Count(List<Integer> lotto, int lottoBonus, List<LottoTicket> lottoTickets) {
		count = new ArrayList<>();
		for (LottoTicket lottoTicket : lottoTickets) {
			Map<String, Integer> ticket = getTicket(lotto, lottoBonus, lottoTicket);
			count.add(ticket);
		}
	}

	public List<Map<String, Integer>> getCount() {
		return count;
	}

	private Map<String, Integer> getTicket(List<Integer> lotto, int lottoBonus, LottoTicket lottoTicket) {
		Map<String, Integer> ticket = new HashMap<>();
		ticket.put(LOTTO, countLottoNumber(lotto, lottoTicket.getNumbers()));
		ticket.put(BONUS, countBonusNumber(lottoBonus, lottoTicket.getNumbers()));
		return ticket;
	}

	private int countBonusNumber(int lottoBonus, List<Integer> lottoTicket) {
		int bonusNumber = 0;
		if (lottoTicket.contains(lottoBonus)) {
			bonusNumber = 1;
		}
		return bonusNumber;
	}

	private int countLottoNumber(List<Integer> lotto, List<Integer> lottoTicket) {
		int lottoNumber = 0;
		for (int number : lottoTicket) {
			if (lotto.contains(number)) {
				lottoNumber++;
			}
		}
		return lottoNumber;
	}
}
