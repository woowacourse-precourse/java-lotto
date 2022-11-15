package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputWinningNums() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNum() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
