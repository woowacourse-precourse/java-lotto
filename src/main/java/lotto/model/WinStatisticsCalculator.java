package lotto.model;

import static lotto.controller.WinStatisticsStatus.*;
import static lotto.model.LotteryInformation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinStatisticsCalculator {
	private final List<Lotto> lotteryTickets;
	private final Lotto winningNumbers;
	private final int bonusNumber;
	private final Map<Integer, Integer> matchResult = new HashMap<>();

	public WinStatisticsCalculator(List<Lotto> lotteryTickets, Lotto winningNumbers) {
		this.lotteryTickets = lotteryTickets;
		this.winningNumbers = winningNumbers;
		this.bonusNumber = winningNumbers.getBonusNumber();
		initMatchResult();
	}

	private void initMatchResult() {
		for (int key = FOURTH_PLACE.getRank(); key <= BONUS_PLACE.getRank(); key++) {
			matchResult.put(key, 0);
		}
	}

	public void calculateWinningStatus() {
		for (Lotto ticket : lotteryTickets) {
			List<Integer> combinationNumbers = Stream.concat(ticket.getNumbers().stream(),
					winningNumbers.getNumbers().stream())
				.collect(Collectors.toList());
			List<Integer> deduplicationNumbers = combinationNumbers.stream().distinct().collect(Collectors.toList());
			int matchNumber = combinationNumbers.size() - deduplicationNumbers.size();
			if (matchNumber == 5 && checkBonusMatching(ticket)) {
				updateMatchResult(CHECK_BONUS.getCode());
				continue;
			}
			if (matchNumber > 0) {
				updateMatchResult(matchNumber);
			}
		}
	}

	private boolean checkBonusMatching(Lotto ticket) {
		return ticket.getNumbers().contains(bonusNumber);
	}

	private void updateMatchResult(int matchNumber) {
		if (matchResult.containsKey(matchNumber)) {
			matchResult.put(matchNumber, matchResult.get(matchNumber) + 1);
			return;
		}
		matchResult.put(matchNumber, 1);
	}

	public Map<Integer, Integer> getMatchResult() {
		return matchResult;
	}
}
