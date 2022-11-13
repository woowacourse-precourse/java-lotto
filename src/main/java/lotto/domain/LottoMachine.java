package lotto.domain;

import java.util.List;

public class LottoMachine {
    public static List<Lotto> publish(int inputMoney) {
        int countOfLottos = getCountOfLottos(inputMoney);
        List<Lotto> lottos = publishLottosByCount(countOfLottos);
        return lottos;
    }
}
