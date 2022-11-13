package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.Quantity;

public class OutputView {

    private static final String LOTTO_QUANTITY_MESSAGE = "개를 구매했습니다.";

    public static void printLottoQuantity(Quantity quantity) {
        String result = quantity.getNumber()
                + " "
                + LOTTO_QUANTITY_MESSAGE;

        System.out.println(result);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
