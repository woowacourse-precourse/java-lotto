package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.MessageConstant.*;

public class CheckWin {

    private List<List<Integer>> userAllLotto;
    private List<Integer> winNumber;
    private List<Integer> prize = new ArrayList<>();
    private int bonus;
    private int bonusCount = 0;

    public CheckWin(List<List<Integer>> userAllLotto, List<Integer> winNumber, int bonus) {
        this.userAllLotto = userAllLotto;
        this.winNumber = winNumber;
        this.bonus = bonus;
        for (int i = 0; i < 8; i++) {
            prize.add(i, 0);
        }
    }

    public List<Integer> compareNumber() {
        for (List<Integer> userLotto: userAllLotto) {
            int correctNumber = compare(userLotto);
            int prizeCount = prize.get(correctNumber) + 1;
            prize.remove(correctNumber);
            prize.add(correctNumber, prizeCount);
        }
        return prize;
    }

    public int compare(List<Integer> lotto) {
        int count = 0;
        for (int i = 0; i < LOTTO_NUMBER_COUNT.getValue(); i++) {
            int number = lotto.get(i);
            if (winNumber.contains(number)) {
                count++;
            }
        }
        if (count == 5 && lotto.contains(bonus)) {
            int prizeCount = prize.get(7) + 1;
            prize.remove(7);
            prize.add(7, prizeCount);
            return 0;
        }
        return count;
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE.getMessage());
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 3, FIFTH.getMessage(), prize.get(3)));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 4, FOURTH.getMessage(), prize.get(4)));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 5, THIRD.getMessage(), prize.get(5)));
        System.out.println(String.format(BONUS_COUNT.getMessage(), SECOND.getMessage(), bonusCount));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 6, FIRST.getMessage(), prize.get(6)));
    }

    public List<Integer> getPrize() {
        return prize;
    }
}
