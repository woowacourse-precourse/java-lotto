package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        isDigit(money);
        canDivideByKilo(money);
        return Integer.parseInt(money);
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = readLine();
        return inputWinningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = readLine();
        isDigit(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private static void isDigit(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    private static void canDivideByKilo(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            String ERROR = "[ERROR] 천 원단위로 입력해 주세요.";
            throw new IllegalArgumentException(ERROR);
        }
    }

}
