package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Guide;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int askPurchaseAmount() {
        Guide.ASK_PURCHASE_AMOUNT.print();
        return Integer.parseInt(Console.readLine());
    }
}
