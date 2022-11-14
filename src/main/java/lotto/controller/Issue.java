package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Issue {
    public int count;
    public int userPrice;
    public List<List<Integer>> userLotto;

    public Issue() {
        userPrice = InputView.InputPrice();
        if (!Check1000(userPrice)) {
            throw new IllegalArgumentException("[ERROR] 구매 가격이 1,000원 단위가 아닙니다.");
        }
        this.count = CountLotto(userPrice);
        this.userLotto = IssueLotto(count);
        OutputView.OutputIssueLotto(count,userLotto);
    }

    private int CountLotto(int userPrice) {
        int count = userPrice/1000;
        return count;
    }

    private boolean Check1000(int userPrice) {
        if (userPrice%1000 == 0) {
            return true;
        }
        return false;
    }

    public List<List<Integer>> IssueLotto(int count) {
        List<List<Integer>> userLotto = new ArrayList<>(count);
        for (int c = 0; c <count; c++) {
            userLotto.add(Randoms.pickUniqueNumbersInRange(1,45,6));
        }

        return userLotto;
    }
}
