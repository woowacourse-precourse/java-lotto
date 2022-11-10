package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validation;

public class InputView {
    public static int inputMoney;

    public static void inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoneyString = Console.readLine();
        Validation.validateInputMoney(inputMoneyString);
        inputMoney = Integer.parseInt(inputMoneyString);
    }


    public static void showNumberOfLottos(int money, int lottoPrice) {
        System.out.println(money / lottoPrice + "개를 구매했습니다.");
    }
}
