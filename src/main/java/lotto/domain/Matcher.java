package lotto.domain;

import java.util.List;

public class Matcher {
    private final int matchingWinningNumberCount;
    private final int matchingBonusNumberCount;

    public Matcher(List<Integer> lottoTicket, List<Integer> winningNumbers, Integer bonusNumber) {
        matchingWinningNumberCount = compareWinningNumbers(lottoTicket, winningNumbers);
        matchingBonusNumberCount = compareBonusNumber(lottoTicket, bonusNumber);
    }

    public int getMatchingWinningNumberCount() {
        return matchingWinningNumberCount;
    }

    public int getMatchingBonusNumberCount() {
        return matchingBonusNumberCount;
    }

    private int compareWinningNumbers(List<Integer> lottoTicket, List<Integer> winningNumbers) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            matchingCount = updateMatchingCount(lottoTicket, winningNumbers.get(i), matchingCount);
        }
        return matchingCount;
    }

    private int compareBonusNumber(List<Integer> lottoTicket, Integer bonusNumber) {
        int matchingCount = 0;
        matchingCount = updateMatchingCount(lottoTicket, bonusNumber, matchingCount);
        return matchingCount;
    }

    private int updateMatchingCount(List<Integer> lottoTicket, Integer number, int matchingCount) {
        if (lottoTicket.contains(number)) {
            matchingCount++;
        }
        return matchingCount;
    }
}
