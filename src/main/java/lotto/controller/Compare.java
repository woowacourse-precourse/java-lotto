package lotto.controller;

import lotto.model.Lotto;
import lotto.view.OutputView;

import java.util.List;

public class Compare {
    int count;
    boolean bonusHit;
    int fifth = 0;

    public Compare(List<List<Integer>> userLotto, Lotto winLotto, int bonusLotto) {
        for (int paper = 0; paper < userLotto.size(); paper++) {
            this.count = CountLotto(userLotto.get(paper),winLotto,paper);
            System.out.println(count);
            if (count == 5) {
                bonusHit = IsBonus(userLotto.get(paper), bonusLotto);
            }
            Result(count,bonusHit);
        }
        Win();
    }

    private int CountLotto(List<Integer> nowUserLotto, Lotto winLotto, int paper) {
        int count = 0;
        for (int number = 0; number < 6; number++) {
            if (winLotto.Contain(nowUserLotto.get(number))) {
                count += 1;
            }
        }
        return count;
    }

    private boolean IsBonus(List<Integer> nowUserLotto, int bonusLotto) {
        if (nowUserLotto.contains(bonusLotto)) {
            return true;
        }
        return false;
    }

    public void Result(int count, boolean bonusHit) {
        if (count == 3) {
            fifth += 1;
        }
    }

    public void Win() {
        OutputView.OutputWinLotto();
        OutputView.FifthLotto(fifth);
    }
}
