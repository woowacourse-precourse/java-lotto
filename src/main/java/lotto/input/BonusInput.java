package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.stream.Stream;

import lotto.output.ErrorMessage;
import lotto.output.Message;

public class BonusInput {
    public static String bonusInput;

    public static void inputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER_INPUT.getMessage());
        bonusInput = readLine();
        validateInputBonusNumber(bonusInput);
        System.out.println();
    }

    private static void validateInputBonusNumber(String bonusInput) {
        Integer[] bonusNumberArr = Stream.of(bonusInput)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        if (bonusNumberArr[0] < 1 || bonusNumberArr[0] > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER.getErrorMessage());
        }
    }
}
