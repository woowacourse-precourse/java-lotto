package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

import java.util.LinkedList;
import java.util.List;

import static lotto.LottoConfiguration.*;
import static lotto.LottoConfiguration.PRICE;

public class Receipt {
    private int money;
    private int amount;

    public Receipt(String input) {
        validate(input);
        money = Integer.parseInt(input);
        amount = money / 1000;
    }

    private void validate(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
            if (money > 0 && money % PRICE == 0) {
                return;
            }
        } catch (NumberFormatException ignored) {
        }
        throw new MyIllegalArgumentException(ErrorCode.MONEY_ERROR);
    }

    public List<Lotto> buy() {
        List<Lotto> lottos = new LinkedList<Lotto>();
        List<Integer> numbers;
        for (int i = 0; i < amount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
