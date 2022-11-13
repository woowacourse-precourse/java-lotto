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
        validate(winningLotto, bonusNumber);
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

        isFirstPrize(duplicate);
        isSecondPrize(duplicate, bonus);
        isThirdPrize(duplicate, bonus);
        isFourthPrize(duplicate);
        isFifthPrize(duplicate);
    }

    private void isFirstPrize(int duplicate) {
        if (duplicate == 6) {
            first += 1;
        }
    }

    private void isSecondPrize(int duplicate, boolean bonus) {
        if (duplicate == 5 && bonus) {
            second += 1;
        }
    }

    private void isThirdPrize(int duplicate, boolean bonus) {
        if (duplicate == 5 && !bonus) {
            third += 1;
        }
    }

    private void isFourthPrize(int duplicate) {
        if (duplicate == 4) {
            fourth += 1;
        }
    }

    private void isFifthPrize(int duplicate) {
        if (duplicate == 3) {
            fifth += 1;
        }
    }
    private void validate(List<Integer> numbers, int number) {
        if (! isValidUnique(numbers, number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    private boolean isValidUnique(List<Integer> numbers, int number) {
        return ! numbers.contains(number);
    }
}

