package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.enums.NumbersType;

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
        numbers = Randoms.pickUniqueNumbersInRange(NumbersType.START_INCLUSIVE.getValue(),
                NumbersType.END_INCLUSIVE.getValue(), NumbersType.NUMBERS_SIZE.getValue());
        return numbers;
    }
}