package lotto.domain;

import lotto.ui.Constants;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    private final Lotto winnerNumbers;
    private final Integer bonusNumber;

    public Draw(Lotto winnerNumbers, Integer bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer resultLottery(List<Lotto> Lottos) {
        List<Integer> lottoCorrectCount = new ArrayList<>();
        List<Boolean> bonusCorrect = new ArrayList<>();
        for (Lotto lotto : Lottos) {
            List<Integer> target = lotto.getNumbers();
            int count = countSameNumber(target);
            lottoCorrectCount.add(count);
            bonusCorrect.add(lotto.hasNumber(bonusNumber));
        }
        int[] result = countResult(lottoCorrectCount, bonusCorrect);
        viewResult(result);
        return winnings(result);
    }

    private Integer winnings(int[] result) {
        Integer money = 0;
        for (int i = 0; i < Constants.PRINT_SIZE; i++) {
            money += (result[i] * Constants.winningMoney[i]);
        }
        return money;
    }

    private Integer countSameNumber(List<Integer> target) {
        int count = 0;
        List<Integer> winner = winnerNumbers.getNumbers();
        for (Integer integer : target) {
            if (winner.contains(integer)) {
                count += 1;
            }
        }
        return count;
    }

    private int[] countResult(List<Integer> lottoCorrectCount, List<Boolean> bonusCorrect) {
        int[] result = new int[5];
        for (int i = 0; i < lottoCorrectCount.size(); i++) {
            int count = lottoCorrectCount.get(i);
            // 6개 모두 일치한 경우
            if (count == 6) {
                result[4] += 1;
            }
            // 5개 + 보너스 번호가 일치한 경우
            else if (count == 5 && bonusCorrect.get(i)) {
                result[3] += 1;
            }
            else if (count > 2) {
                result[count - 3] += 1;
            }
        }
        return result;
    }

    private void viewResult(int[] result) {
        System.out.println("당첨 통계\n" +
                "---");
        for (int i = 0; i < Constants.PRINT_SIZE; i++) {
            printLine(i, result);
        }
    }

    private void printLine(int idx, int[] result) {
        System.out.println(Constants.printTable[idx] + result[idx] + "개");
    }

    private void validate(Integer bonusNumber) {
        if (!isCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (winnerNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isCorrectRange(Integer number) {
        return 1 <= number && number <= 45;
    }
}

