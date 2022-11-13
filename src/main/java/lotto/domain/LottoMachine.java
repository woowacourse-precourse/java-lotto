package lotto.domain;

import static lotto.constant.LottoRule.AMOUNT_OF_ONE_LOTTO;

import java.util.List;

public class LottoMachine {
    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = getCountOfLottos(inputMoney);
        List<Lotto> lottos = publishLottosByCount(countOfLottos);
        return lottos;
    }

    private static int getCountOfLottos(int inputMoney) {
        return inputMoney / AMOUNT_OF_ONE_LOTTO;
    }
}
