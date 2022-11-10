package lotto.service;

import java.util.List;
import lotto.Lotto;

public class OutputService {

    public static String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_MESSAGE);
        lottos.forEach(System.out::println);
    }

}
