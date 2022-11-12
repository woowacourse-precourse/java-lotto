package lotto.io;

import lotto.Lotto;

import java.util.List;

public class MessagePrinter {
    public static void printMoneyInputRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printGeneratedLottoQuantity(int lottoQuantity) {
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public static void printGeneratedLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
