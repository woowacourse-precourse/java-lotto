package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static util.LottoRule.START_INCLUSIVE;
import static util.LottoRule.END_INCLUSIVE;
import static util.LottoRule.NUMBER_OF_SIZE;

public class LottoMachine {

    private final int amountInput;

    public LottoMachine(int amountInput) {
        this.amountInput = amountInput;
    }

    private Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_OF_SIZE);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
