package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String priceInput() {
        System.out.println("구입 금액을 입력하세요 : ");
        String userMoney = Console.readLine();

        return userMoney;
    }
}
