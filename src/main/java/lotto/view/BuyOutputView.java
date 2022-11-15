package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class BuyOutputView {
    public static void guideBuying() {
        System.out.print("구입금액을 입력해 주세요: ");
    }

    public static void printTheNumberOfBuyingLottos(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
