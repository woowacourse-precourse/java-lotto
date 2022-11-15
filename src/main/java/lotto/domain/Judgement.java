package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    public List<Integer> winningTable = new ArrayList<>();

    public int rankLotto(List<Integer> lottery, List<Integer> winningNumber) {
        int result = 0;
        for (int idx = 0; idx < lottery.size(); idx++) {
            int correctNumber = winningNumber.get(idx);
            if (lottery.contains(correctNumber)) {
                result++;
            }
        }
        return result;
    }

    public boolean secondPrize(List<Integer> lottery, int bonus, int result) {
        boolean second = false;
        if (result == 5) {
            if (lottery.contains(bonus)) {
                second = true;
            }
        }
        return second;
    }

    public List<Integer> makeWinningTable(List<List<Integer>> lotteries, List<Integer> winningNumber, int bonus) {
        for (List<Integer> lottery : lotteries) {
            int result = rankLotto(lottery, winningNumber);
            if (secondPrize(lottery, bonus, result)) {
                winningTable.add(7); //2등의 경우, 나올 수 없는 갯수로 구분
            }
            winningTable.add(result);
        }
        return winningTable;
    }
}
