package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RankCounter {
	private final List<Integer> ranks;

	public RankCounter(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		this.ranks = sortRanks(lottoTickets, winningNumbers);
	}

	public List<Integer> getRanks() {
		return Collections.unmodifiableList(ranks);
	}

	private List<Integer> sortRanks(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		int[] ranks = {0, 0, 0, 0, 0};
		for (Lotto lottoTicket : lottoTickets) {
			ranks[countRank(lottoTicket, winningNumbers)]++;
		}
		return Arrays.stream(ranks).boxed().collect(Collectors.toList());
	}

	private int countRank(Lotto lottoTicket, WinningNumbers winningNumbers) {
		List<Integer> intersection = new ArrayList<>(lottoTicket.getNumbers());
		intersection.retainAll(winningNumbers.getWinningNumbers());
		return intersection.size() + addBonusPoint(lottoTicket, winningNumbers, intersection);
	}

	private int addBonusPoint(Lotto lottoTicket, WinningNumbers winningNumbers, List<Integer> intersection) {
		if (isThirdRank(intersection) && isContainsBonusNumber(lottoTicket, winningNumbers)) {
			return 1;
		}
		return 0;
	}

	private boolean isContainsBonusNumber(Lotto lottoTicket, WinningNumbers winningNumbers) {
		return lottoTicket.getNumbers().contains(winningNumbers.getBonusNumbers());
	}

	private boolean isThirdRank(List<Integer> intersection) {
		return intersection.size() == 5;
	}

}
