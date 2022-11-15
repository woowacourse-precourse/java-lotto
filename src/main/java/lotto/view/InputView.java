package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
