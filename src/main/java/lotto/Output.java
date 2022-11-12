package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output {
    public static void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println("");
    }
}
