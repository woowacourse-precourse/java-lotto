package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.stream.Stream;

public class BonusInput {
    public static String bonusNumber;

    public static void bonusNumberInput() {
        System.out.println(Message.BONUS_NUMBER_INPUT.getMessage());
        bonusNumber = readLine();
        validateInputBonusNumber(bonusNumber);
    }

    private static void validateInputBonusNumber(String bonusNumber) {
        Integer[] bonusNumberArr = Stream.of(bonusNumber)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        if (bonusNumberArr[0] < 1 || bonusNumberArr[0] > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NUMBER.getErrorMessage());
        }
    }
}
