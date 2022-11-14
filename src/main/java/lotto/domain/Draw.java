package lotto.domain;

import lotto.ui.Constants;

import java.util.ArrayList;
import java.util.List;

public class Draw {
    private final Lotto winnerNumbers;
    private final Integer bonusNumber;
    Constants.Statistic THREE = Constants.Statistic.THREE;
    Constants.Statistic FOUR = Constants.Statistic.FOUR;
    Constants.Statistic FIVE = Constants.Statistic.FIVE;
    Constants.Statistic FIVE_BONUS = Constants.Statistic.FIVE_BONUS;
    Constants.Statistic SIX = Constants.Statistic.SIX;

    public Draw(Lotto winnerNumbers, Integer bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer resultLottery(List<Lotto> Lottos) {
        List<Integer> lottoCorrectCount = new ArrayList<>();
        for (Lotto lotto : Lottos) {
            List<Integer> target = lotto.getNumbers();
            int count = countSameNumber(target);
            if (count == FIVE.getCorrectNumber() && lotto.hasNumber(bonusNumber)){
                count += 10;
            }
            lottoCorrectCount.add(count);
        }

        countResult(lottoCorrectCount);
        viewResult();
        return winnings();
    }

    private Integer winnings() {
        Integer money = 0;
        money += SIX.getAllPrize();
        money += FIVE.getAllPrize();
        money += FIVE_BONUS.getAllPrize();
        money += FOUR.getAllPrize();
        money += THREE.getAllPrize();

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

    private void countResult(List<Integer> lottoCorrectCount) {
        for (int count : lottoCorrectCount) {
            if (count == SIX.getCorrectNumber()) {
                SIX.addCount();
            } else if (count == FIVE_BONUS.getCorrectNumber()) {
                FIVE_BONUS.addCount();
            } else if (count == FIVE.getCorrectNumber()) {
                FIVE.addCount();
            } else if (count == FOUR.getCorrectNumber()) {
                FOUR.addCount();
            } else if (count == THREE.getCorrectNumber()) {
                THREE.addCount();
            }
        }
    }

    private void viewResult() {
        System.out.println("당첨 통계\n" +
                "---");
        System.out.println(THREE.getPrint() + THREE.getCount() + "개");
        System.out.println(FOUR.getPrint() + FOUR.getCount() + "개");
        System.out.println(FIVE.getPrint() + FIVE.getCount() + "개");
        System.out.println(FIVE_BONUS.getPrint() + FIVE_BONUS.getCount() + "개");
        System.out.println(SIX.getPrint() + SIX.getCount() + "개");
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

