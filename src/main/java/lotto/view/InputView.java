package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readInputMoney() {

        System.out.println("구입금액을 입력해 주세요.");
        return convertStrToInt(Console.readLine());
    }

    public static int convertStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다");
        }
    }
}
