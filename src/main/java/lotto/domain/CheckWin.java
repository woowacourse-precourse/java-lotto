package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;

public class CheckWin {

    List<List<Integer>> userAllLotto;
    List<Integer> winNumber;
    List<Integer> prize = new ArrayList<>();

    public CheckWin(List<List<Integer>> userAllLotto, List<Integer> winNumber) {
        this.userAllLotto = userAllLotto;
        this.winNumber = winNumber;
        for (int i = 0; i < 6; i++) {
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
        return count;
    }
}
