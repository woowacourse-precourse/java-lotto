package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Machine {
    public void buy(int amount) {
        int lottoCount = getCount(amount);
    }

    public int getCount(int amount) {
        return amount / 1000;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
