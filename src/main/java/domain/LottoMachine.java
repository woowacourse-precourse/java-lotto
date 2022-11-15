package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static util.LottoRule.PURCHASE_UNIT;
import static util.LottoRule.START_INCLUSIVE;
import static util.LottoRule.END_INCLUSIVE;
import static util.LottoRule.NUMBER_OF_SIZE;

public class LottoMachine {

    private final int amountInput;

    public LottoMachine(int validatedMoney) {
        this.amountInput = validatedMoney;
    }

    public List<Lotto> lottoForAmount() {
        List<Lotto> lotteries = new ArrayList<>();
        for (int count = 0; count < amountInput / PURCHASE_UNIT; count++) {
            lotteries.add(issueLotto());
        }
        return lotteries;
    }

    private Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_OF_SIZE);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
