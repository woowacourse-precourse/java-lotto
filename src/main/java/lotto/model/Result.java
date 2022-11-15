package lotto.model;

import java.util.HashMap;

public class Result {
    private static final int DEFAULT_PRIZE_COUNT = 0;
    private static final int SECOND_OR_THIRD_MATCHING_COUNT = 5;

    private final HashMap<Prize, Integer> prizeCount = new HashMap<>();

    public Result(LottoTickets lottoTickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        setDefaultPrizeCount(prizeCount);
        updateLottoTicketsResult(lottoTickets, winningNumbers, bonusNumber);
    }

    public HashMap<Prize, Integer> getPrizeCount() {
        return prizeCount;
    }

    private void setDefaultPrizeCount(HashMap<Prize, Integer> prizeCount) {
        for (Prize e : Prize.values()) {
            prizeCount.put(e, DEFAULT_PRIZE_COUNT);
        }
    }

    private void updateLottoTicketsResult(LottoTickets lottoTickets, WinningNumbers winningNumbers,
                                          BonusNumber bonusNumber) {
        for (Lotto lotto : lottoTickets.getTickets()) {
            updateLottoResult(lotto, winningNumbers, bonusNumber);
        }
    }

    private void updateLottoResult(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchingCnt = countMatchingNumbers(lotto, winningNumbers);
        boolean isBonus = isBonusNumberCorrect(lotto, bonusNumber);
        filterSecondOrThirdPrize(matchingCnt, isBonus);
        for (Prize e : Prize.values()) {
            if (matchingCnt != SECOND_OR_THIRD_MATCHING_COUNT && e.getMatchingCount() == matchingCnt) {
                prizeCount.put(e, prizeCount.get(e) + 1);
            }
        }
    }

    private void filterSecondOrThirdPrize(int matchingCnt, boolean isBonus) {
        if (matchingCnt == SECOND_OR_THIRD_MATCHING_COUNT) {
            if (isBonus) {
                prizeCount.put(Prize.SECOND, prizeCount.get(Prize.SECOND) + 1);
                return;
            }
            prizeCount.put(Prize.THIRD, prizeCount.get(Prize.THIRD) + 1);
        }
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        int matchingCount = 0;
        for (int number : winningNumbers.getWinningNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private boolean isBonusNumberCorrect(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
