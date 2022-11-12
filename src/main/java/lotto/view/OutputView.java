package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static String BUY_INFORM_MESSAGE = "%d개를 구매했습니다.";

    public static void printUserLottos(List<Lotto> userLottos){
        System.out.println(String.format(BUY_INFORM_MESSAGE, userLottos.size()));
        for(Lotto lotto : userLottos){
            System.out.println(lotto.toString());
        }
    }
}