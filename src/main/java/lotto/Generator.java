package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Generator {

    public static String userInput() {
        String userMoney;

        System.out.println("구입 금액을 입력하세요 : ");
        userMoney = Console.readLine();

        return userMoney;
    }

}
