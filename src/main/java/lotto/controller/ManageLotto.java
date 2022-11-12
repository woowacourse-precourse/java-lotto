package lotto.controller;

import lotto.model.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class ManageLotto {
    private final static int LOTTOPRICE = 1000;
    public static int lottoNum;
    public List<Lotto> myLotto = new ArrayList<>();

    public void makeMyLotto(int number) {
        myLotto.clear();
        for (int count = 0; count < number; count++) {
            myLotto.add(new Lotto(pickNumbers()));
        }
    }

    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void numberOfLotto (String budget) {
        lottoNum = Integer.valueOf(budget) / LOTTOPRICE;
    }
}
