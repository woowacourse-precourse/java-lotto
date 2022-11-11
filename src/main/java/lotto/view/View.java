package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String printUserInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
