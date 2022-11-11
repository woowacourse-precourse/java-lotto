package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int MONEY_UNIT = 1000;

    public static List<Lotto> buyLottos(int money) {
        NumbersValidator.validateMoney(money);
        int quantity = money / MONEY_UNIT;

        return IntStream.range(0, quantity)
                .mapToObj(i -> Lotto.generate())
                .collect(Collectors.toList());
    }

}
