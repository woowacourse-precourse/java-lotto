package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCounter {
	private final Map<Rank, Integer> scoreBoard;

	public RankCounter(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		this.scoreBoard = recordScoreBoard(lottoTickets, winningNumbers);
	}

	public Map<Rank, Integer> getScoreBoard() {
		return Collections.unmodifiableMap(scoreBoard);
	}

	private Map<Rank, Integer> recordScoreBoard(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
		Map<Rank, Integer> scoreBoard = getNewScoreBoard();
		for (Lotto lottoTicket : lottoTickets) {
			Rank key = judgeRank(lottoTicket, winningNumbers);
			scoreBoard.put(key, scoreBoard.get(key) + 1);
		}
		return scoreBoard;
	}

	private Map<Rank, Integer> getNewScoreBoard() {
		Map<Rank, Integer> newScoreBoard = new HashMap<>();
		for (Rank rank : Rank.values()) {
			newScoreBoard.put(rank, 0);
		}
		return newScoreBoard;
	}

	private Rank judgeRank(Lotto lottoTicket, WinningNumbers winningNumbers) {
		List<Integer> intersection = new ArrayList<>(lottoTicket.getLottoNumbers());
		intersection.retainAll(winningNumbers.getWinningNumbers());
		return Rank.of(intersection.size(), isContainsBonusNumber(lottoTicket, winningNumbers));
	}

	private boolean isContainsBonusNumber(Lotto lottoTicket, WinningNumbers winningNumbers) {
		return lottoTicket.getLottoNumbers().contains(winningNumbers.getBonusNumbers());
	}

}
