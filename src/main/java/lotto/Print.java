package lotto;

import java.util.List;

public class Print {
    private static String MESSAGE_INSERT_MONEY = "구매금액을 입력해 주세요.";

    public static void printInsertMoney() {
        System.out.println(MESSAGE_INSERT_MONEY);
    }

    public static void printLotto(List<Lotto> lottos) {
        for (int lottoIndex = 0; lottoIndex < lottos.size(); lottoIndex++) {
            System.out.println(lottos.get(lottoIndex));
        }
    }
}
