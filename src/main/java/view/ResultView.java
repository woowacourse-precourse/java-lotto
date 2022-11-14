package view;

import controller.Result;
import domain.User;

import java.util.HashMap;

public class ResultView {

    public void resultLotto(HashMap<String, Integer> winningLotto) {
        int totalYield = 0;
        for (Result rank : Result.values()) {
            System.out.println(rank.getCondition() + " (" + rank.getWinningCount() + ")" + " - " + winningLotto.get(rank.getWinningNumber()) + "개");
            if (winningLotto.get(rank.getWinningNumber()) != 0) {
                totalYield += convertToMoney(rank.getWinningCount());
            }
        }
        resultYield(totalYield);
    }

    private int convertToMoney(String winningCount) {
        String convertWinningCount = winningCount.replaceAll(",", "");
        return Integer.parseInt(convertWinningCount);
    }

    private void resultYield(int totalYield) {
        User inputMoney = new User();
        double yieldRate = ((double) totalYield / inputMoney.getInputUserMoney()) * 100;
        System.out.println("총 수익률은 " + yieldRate + "%" + "입니다");
    }
}
