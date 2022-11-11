package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return parseInt(input, "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.");
    }

    public static String askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseInt(input, "[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
    }

    private static int parseInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }
}
