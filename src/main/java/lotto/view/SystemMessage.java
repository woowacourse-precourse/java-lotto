package lotto.view;

import lotto.entity.Lotto;

import java.util.List;
import java.util.Objects;

public class SystemMessage {
    public static void whenPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printAmount(int count) {
        System.out.println(Objects.toString(count)+"개를 구매했습니다.");
    }
    public static void printLottoNumber(List<Lotto> generatedLottos) {
        for (Lotto lotto : generatedLottos) {
            List<Integer> number = lotto.getNumbers();
            System.out.println(number);
        }
    }
}
