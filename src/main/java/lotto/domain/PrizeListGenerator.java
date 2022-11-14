package lotto.domain;

import lotto.Lotto;
import lotto.prizestandards.PrizeStandards;
import lotto.ui.input.WinnerNumberGetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeListGenerator {
    private static final String BONUS_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호와 당첨 번호는 중복되서는 안됩니다.";

    private Map<Enum, Integer> winnerResult = new HashMap<>();
    private Map<Integer, Integer> winningNumbers;
    private int bonus;

    private int score;

    public PrizeListGenerator() throws IllegalArgumentException{  /* 생성자로 이 기능 옮긴 것 커밋에 반영해야함 */
            winningNumbers = WinnerNumberGetter.getLotteryWinningNumbersInput();
            bonus = WinnerNumberGetter.getBonusInput();

            if (winningNumbers.containsKey(bonus)) {
                throw new IllegalArgumentException(BONUS_DUPLICATED_WITH_WINNING_NUMBER);
            }
    }

    public void iterateLotteriesForStatistic(List<Lotto> lotteries) {
        score = 0;
        for (Lotto lottery : lotteries) { // 당첨 계산하는 제일 핵심로직  시간복잡도 개선방법 생각해보기
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

    private Enum<PrizeStandards> getCorrespondingPrizeStandard(int score) { // private으로 변경 커밋필요
        return PrizeStandards.getProperStandard(score);
    }

    public Map<Enum, Integer> returnWinnerResult() {
        return winnerResult;
    }
}
