package lotto.controller;

import lotto.model.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class ManageLotto {
    public List<Lotto> makeMYLotto(int number) {
        List<Lotto> myLotto = new ArrayList<>();
        for (int count = 0; count < number; count++) {
            myLotto.add(new Lotto(pickNumbers()));
        }

        return myLotto;
    }

    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
