package lotto.console;

import camp.nextstep.edu.missionutils.Console;


public class Input {

    public static int inputMoney() {
        String money = Console.readLine();
        isCorrectPattern(money);
        isFirstNumberZero(money);
        return Integer.parseInt(money);
    }

    private static void isFirstNumberZero(String money) {
        if (money.charAt(0) == '0') {
            throw new IllegalArgumentException("첫 자리는 0을 입력할 수 없습니다.");
        }
    }

    private static void isCorrectPattern(String money) {
        if (!money.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static String[] inputLottoNumbers() {
        return Console.readLine().split(",");
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
