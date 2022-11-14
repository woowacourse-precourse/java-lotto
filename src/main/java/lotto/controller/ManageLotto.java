package lotto.controller;

import lotto.model.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class ManageLotto {
    private final static int LOTTOPRICE = 1000;
    private int lottoNum;
    private int budget;
    private List<Lotto> myLotto = new ArrayList<>();

    public ManageLotto(int budget) {
        numberOfLotto(budget);
        makeMyLotto(lottoNum);
    }
    public void makeMyLotto(int number) {
        myLotto.clear();
        for (int count = 0; count < number; count++) {
            myLotto.add(new Lotto(pickNumbers()));
        }
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void numberOfLotto (int budget) {
        this.budget = budget;
        lottoNum = this.budget / LOTTOPRICE;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    public int getBudget() {
        return budget;
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }
}
