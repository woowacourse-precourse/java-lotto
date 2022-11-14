package veiw;

import models.Lotto;

import java.util.List;

public class BuyingView {
    public static void printInputAmountPaidText() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printLottoList(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        lottos.forEach((lotto) -> System.out.println(lotto.getNumbers()));
    }

}
