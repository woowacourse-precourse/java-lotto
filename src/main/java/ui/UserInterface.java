package ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

public class UserInterface {
    private static final int PRICE_UNIT = 1000;
    private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SUCCESS_MESSAGE = "개를 구매했습니다.";

    public static int enterPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        String price = Console.readLine();
        System.out.println();

        return Integer.parseInt(price) / PRICE_UNIT;
    }

    public static void printPurchaseResult(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + PURCHASE_SUCCESS_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }
}
