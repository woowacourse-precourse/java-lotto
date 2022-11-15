package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNING_LOTTO = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public static int inputMoney() throws IllegalArgumentException{
        System.out.println(INPUT_MONEY);
        String input = Console.readLine();
        validateInputMoney(input);

        int inputMoney = Integer.parseInt(input);

        return inputMoney / 1000;
    }

    public static String inputLottoAnswer() {
        System.out.println(INPUT_WINNING_LOTTO);
        String inputLottoAnswer = Console.readLine();
        return inputLottoAnswer;
    }

    public static int inputBonusNum() {
        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNum = Integer.parseInt(Console.readLine());
        return bonusNum;
    }

    private static void validateInputMoney(String input) throws IllegalArgumentException{
        try {
            int inputMoney = Integer.parseInt(input);

            int lottoCount = inputMoney / 1000;
            if (inputMoney - lottoCount * 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
