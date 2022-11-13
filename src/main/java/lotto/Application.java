package lotto;

import static lotto.util.InputImport.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        BuyLotto.prepare_money(ReadLine());
    }
}
