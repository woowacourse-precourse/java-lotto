package lotto;

import java.util.List;

public class LottoManager {

    private final int FIRST_PRIZE = 2_000_000_000;
    private final int SECOND_PRIZE = 30_000_000;
    private final int THIRD_PRIZE = 1_500_000;
    private final int FOURTH_PRIZE = 50000;
    private final int FIFTH_PRIZE = 5000;
    private int[] prize = new int[]{0, 0, 0, 0, 0, 0};
    private Judge judge;

    public LottoManager() {
        this.judge = new Judge();
    }

    public void compare(List<Lotto> lottoList, Lotto winningNumbers, int bonusNumber) {
        int correct;
        boolean bonus;
        for(Lotto lotto : lottoList) {
            correct = judge.containCount(lotto.getNumbers(), winningNumbers.getNumbers());
            bonus = lotto.getNumbers().contains(bonusNumber);
            checkResult(correct, bonus);
        }
    }

    private void isFirst(int correct) {
        if(correct == 6) {
            prize[0]++;
        }
    }
    private void isSecond(int correct, boolean bonus) {
        if(correct == 5 && bonus) {
            prize[1]++;
        }
    }

    private void isThird(int correct, boolean bonus) {
        if(correct == 5 && !bonus) {
            prize[2]++;
        }
    }

    private void isFourth(int correct) {
        if(correct == 4) {
            prize[3]++;
        }
    }

    private void isFifth(int correct) {
        if(correct == 3) {
            prize[4]++;
        }
    }

    public void checkResult(int correct, boolean bonus) {
        isFirst(correct);
        isSecond(correct, bonus);
        isThird(correct, bonus);
        isFourth(correct);
        isFifth(correct);
    }

    public void printResult() {

    }
}
