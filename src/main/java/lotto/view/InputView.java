package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "[ERROR] 구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "[ERROR] 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "[ERROR] 보너스 번호을 입력해 주세요.";
    private static final String TYPE_ERROR = "[ERROR] 숫자만 입력 가능합니다.";

    public static int inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertStringToInt(readLine());
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return readLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return convertStringToInt(readLine());
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }
}
