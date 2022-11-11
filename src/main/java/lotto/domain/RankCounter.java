package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCounter {
	private final Map<Rank, Integer> ranks;

	public RankCounter(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		this.ranks = countRanks(lottoTickets, winningNumbers);
	}

	public Map<Rank, Integer> getRanks() {
		return Collections.unmodifiableMap(ranks);
	}

	private Map<Rank, Integer> countRanks(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		Map<Rank, Integer> ranks = new HashMap<>();

		for (Lotto lottoTicket : lottoTickets) {
			Rank key = countRank(lottoTicket, winningNumbers);
			ranks.put(key, ranks.get(key) + 1);
		}
		return ranks;
	}

	private Rank countRank(Lotto lottoTicket, WinningNumbers winningNumbers) {
		List<Integer> intersection = new ArrayList<>(lottoTicket.getNumbers());
		intersection.retainAll(winningNumbers.getWinningNumbers());
		return Rank.of(intersection.size(), isContainsBonusNumber(lottoTicket, winningNumbers));
	}

	private boolean isContainsBonusNumber(Lotto lottoTicket, WinningNumbers winningNumbers) {
		return lottoTicket.getNumbers().contains(winningNumbers.getBonusNumbers());
	}

}
