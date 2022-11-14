package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoMachine {
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INTEGER = "[ERROR] 보너스 번호는 숫자를 입력해야 합니다.";

    Lotto winningNumber;
    int bonusNumber;

    public void inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String inputNumber = Console.readLine();

        winningNumber = checkThatWinningNumberIsRightInput(inputNumber);
    }

    public List<String> splitNumber(String number) {
        return Arrays.asList(number.split(","));
    }

    public void inputBonusNumber() throws IllegalArgumentException {
        System.out.println(INPUT_BONUS_NUMBER);

        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_INTEGER);
        }
    }

    public Lotto checkThatWinningNumberIsRightInput(String inputNumber) {
        List<String> winningNumberTemp = splitNumber(inputNumber);

        return new Lotto(Exception.changeListStringToInteger(winningNumberTemp));
    }


}
