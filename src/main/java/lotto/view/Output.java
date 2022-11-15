package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;

public class Output {
    private static final String OUTPUT_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";

    public static void inputPurchaseAmount(List<Lotto> lottos) {
        System.out.println(OUTPUT_PURCHASE_LOTTO_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
