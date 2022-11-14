package lotto.controller;

import lotto.model.Lotto;

import java.util.List;

public class Compare {
    int count;

    public Compare(List<List<Integer>> userLotto, Lotto winLotto, int bonusLotto) {
        for (int paper = 0; paper < userLotto.size(); paper++) {
            count = 0;
            for (int number = 0; number < 6; number++) {
                if (winLotto.Contain(userLotto.get(paper).get(number))) {
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }
}
