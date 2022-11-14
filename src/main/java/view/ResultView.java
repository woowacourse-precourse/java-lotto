package view;

import controller.Result;

import java.util.HashMap;

public class ResultView {
    public void resultLotto(HashMap<String, Integer> winningLotto) {
        for (Result rank : Result.values())
            System.out.println(rank.getCondition() + " (" + rank.getWinningCount() + ")" + " - " + winningLotto.get(rank.getWinningNumber()) + "개");
    }
}
