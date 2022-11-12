package lotto;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private final List<Integer> WINNING_LOTTO;
    private final int BONUS_NUMBER;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public Statistics(List<Integer> winningLotto, int bonusNumber) {
        this.WINNING_LOTTO = winningLotto;
        this.BONUS_NUMBER = bonusNumber;
    }

    public void compare(List<List<Integer>> lottos, int purchaseAmount) {
        for (List<Integer> integers : lottos) {
            prize(integers);
        }
        List<Integer> result = new ArrayList<>(List.of(fifth, fourth, third, second, first));
        OutputView outputView = new OutputView(result, purchaseAmount);
    }

    private void prize(List<Integer> lotto) {
        boolean bonus = lotto.contains(BONUS_NUMBER);
        lotto.retainAll(WINNING_LOTTO);
        int duplicate = lotto.size();

        isFirstPlace(duplicate);
        isSecondPlace(duplicate, bonus);
        isThirdPlace(duplicate, bonus);
        isFourthPlace(duplicate);
        isFifthPlace(duplicate);
    }

    private void isFirstPlace(int duplicate) {
        if (duplicate == 6) {
            first += 1;
        }
    }

    private void isSecondPlace(int duplicate, boolean bonus) {
        if (duplicate == 5 && bonus) {
            second += 1;
        }
    }

    private void isThirdPlace(int duplicate, boolean bonus) {
        if (duplicate == 5 && !bonus) {
            third += 1;
        }
    }

    private void isFourthPlace(int duplicate) {
        if (duplicate == 4) {
            fourth += 1;
        }
    }

    private void isFifthPlace(int duplicate) {
        if (duplicate == 3) {
            fifth += 1;
        }
    }
}

