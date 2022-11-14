package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void askPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }
}
