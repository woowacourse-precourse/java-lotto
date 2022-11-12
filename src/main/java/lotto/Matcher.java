package lotto;

import java.util.List;

public class Matcher {
    private final int matchingWinningNumberCount;
    private final int matchingBonusNumberCount;

    public Matcher(List<Integer> lottoTicket, List<Integer> winningNumbers, Integer bonusNumber) {
        matchingWinningNumberCount = compare(lottoTicket, winningNumbers);
        matchingBonusNumberCount = checkBonusNumber(lottoTicket, bonusNumber);
    }

    public int getMatchingWinningNumberCount() {
        return matchingWinningNumberCount;
    }

    public int getMatchingBonusNumberCount() {
        return matchingBonusNumberCount;
    }

    private int compare(List<Integer> lottoTicket, List<Integer> winningNumbers) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (lottoTicket.contains(winningNumbers.get(i))) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private int checkBonusNumber(List<Integer> lottoTicket, Integer bonusNumber) {
        int matchingCount = 0;
        if (lottoTicket.contains(bonusNumber)) {
            matchingCount++;
        }
        return matchingCount;
    }
}
