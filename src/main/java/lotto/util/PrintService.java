package lotto.util;


import java.util.List;
import lotto.domain.Lotto;

public class PrintService {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
