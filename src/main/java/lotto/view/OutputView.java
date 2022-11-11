package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.LottoMessage;

public class OutputView {
    public static void printQuantity(int quantity) {
        System.out.println(quantity + LottoMessage.QUANTITY.getMessage());
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }
}
