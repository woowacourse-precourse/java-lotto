package lotto.model;

import static lotto.controller.WinStatisticsStatus.*;
import static lotto.model.LotteryInformation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinStatisticsCalculator {
	private final List<List<Integer>> lotteryTickets;
	private final List<Integer> winningNumbers;
	private final int bonusNumber;
	private final Map<Integer, Integer> matchResult = new HashMap<>();

	public WinStatisticsCalculator(List<List<Integer>> lotteryTickets, List<Integer> winningNumbers) {
		this.lotteryTickets = lotteryTickets;
		this.winningNumbers = winningNumbers;
		this.bonusNumber = winningNumbers.get(BONUS_NUMBER_DIGIT.getCode());
		initMatchResult();
	}

	private void initMatchResult() {
		for (int key = FOURTH_PLACE.getRank(); key <= BONUS_PLACE.getRank(); key++) {
			matchResult.put(key, 0);
		}
	}

	public void calculateWinningStatus() {
		for (List<Integer> ticket : lotteryTickets) {
			List<Integer> combinationNumbers = Stream.concat(ticket.stream(), winningNumbers.stream())
				.collect(Collectors.toList());
			List<Integer> deduplicationNumbers = combinationNumbers.stream().distinct().collect(Collectors.toList());
			int matchNumber = combinationNumbers.size() - deduplicationNumbers.size();
			if (matchNumber == 5 && checkBonusMatching()) {
				updateMatchResult(CHECK_BONUS.getCode());
				continue;
			}
			if (matchNumber > 0) {
				updateMatchResult(matchNumber);
			}
		}
	}

	private boolean checkBonusMatching() {
		return winningNumbers.contains(bonusNumber);
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
