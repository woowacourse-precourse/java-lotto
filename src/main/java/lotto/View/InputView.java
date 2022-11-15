package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getInput() {
        String input = Console.readLine();
        return input;
    }

    public static String getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = InputView.getInput();
        return input;
    }

    public static String getNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = InputView.getInput();
        return input;
    }

    public static String getNumber() {
        System.out.println("보너스 번호 입력해 주세요.");
        String input = InputView.getInput();
        return input;
    }
}