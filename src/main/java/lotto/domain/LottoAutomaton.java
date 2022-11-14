package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoAutomaton {
    private static final int PRICE = 1000;

    private List<Integer> numbers;

    public LottoAutomaton() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCount(String amount) {
        return Integer.parseInt(amount) / PRICE;
    }

    public List<Integer> createNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
