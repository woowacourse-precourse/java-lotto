package lotto.controller;

import lotto.model.Lotto;

import java.util.List;

public class Compare {
    int count;

    public Compare(List<List<Integer>> userLotto, Lotto winLotto, int bonusLotto) {
        for (int paper = 0; paper < userLotto.size(); paper++) {
            this.count = CountLotto(userLotto.get(paper),winLotto,paper);
            System.out.println(count);
        }
    }
    
    public int CountLotto(List<Integer> nowUserLotto, Lotto winLotto, int paper) {
        int count = 0;
        for (int number = 0; number < 6; number++) {
            if (winLotto.Contain(nowUserLotto.get(number))) {
                count += 1;
            }
        }
        return count;
    }
}
