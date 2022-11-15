package lotto.domain;

import lotto.ConstValue;
import lotto.Lotto;
import lotto.prizestandards.PrizeStandards;
import lotto.ui.input.WinnerNumberGetter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeListGenerator {
    private Map<Enum, Integer> winnerResult = new HashMap<>();
    private Map<Integer, Integer> winningNumbers;
    private int bonus;
    private int score;

    public PrizeListGenerator() throws IllegalArgumentException{
        winningNumbers = WinnerNumberGetter.getLotteryWinningNumbersInput();
        bonus = WinnerNumberGetter.getBonusInput();

        if (winningNumbers.containsKey(bonus)) {
            throw new IllegalArgumentException(ConstValue.ErrorMessages.BONUS_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }

    public void iterateLotteriesForStatistic(List<Lotto> lotteries) {
        score = 0;
        for (Lotto lottery : lotteries) {
            List<Integer> numbers = lottery.getNumbers();
            checkIfLotteryContainsWinningnumber(numbers);

            if (score == 10 && numbers.contains(bonus)) {
                score += 1;
            }
            makeNoteToWinnerResult();
            score = 0;
        }
        noteNotRecordedPrizeStandardsToWinnerResult();
    }

    private void checkIfLotteryContainsWinningnumber(List<Integer> numbers) {
        for (int eachNum : numbers) {
            if (winningNumbers.containsKey(eachNum)) {
                score += 2;
            }
        }
    }

    private void makeNoteToWinnerResult() {
        Enum<PrizeStandards> prizeStandardsEnum = getCorrespondingPrizeStandard(score);
        winnerResult.computeIfPresent(prizeStandardsEnum, (k, v) -> v + 1);
        winnerResult.computeIfAbsent(prizeStandardsEnum, v -> 1);
    }

    private void noteNotRecordedPrizeStandardsToWinnerResult() {
        for (PrizeStandards i : PrizeStandards.values()) {
            if (!winnerResult.containsKey(i)) {
                winnerResult.put(i, 0);
            }
        }
    }

    private Enum<PrizeStandards> getCorrespondingPrizeStandard(int score) {
        return PrizeStandards.getProperStandard(score);
    }

    public Map<Enum, Integer> returnWinnerResult() {
        return winnerResult;
    }
}
