package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private static List<Lotto> lottos;

    Consumer() {
        lottos = new ArrayList<>();
    }

    public static void buyLotto() {
        LottoConsoleIo.printRequestPurchase();
        String inputValue = LottoConsoleIo.scanInputValue();
        ValidCheck.formatCheckPrice(inputValue);
        for (int i = 0; i < Integer.parseInt(inputValue); i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        LottoConsoleIo.printNoOfLotto(lottos);
    }
}
