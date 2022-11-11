package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class Output {
    // 상수는 추후 application으로 이동
    private final static String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static final void purchaseSuccessful(Integer cost, List<List<Integer>> lottos) {
        Integer numberOfLottos = cost / 1000;
        System.out.println(numberOfLottos + PURCHASE_MESSAGE);
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
