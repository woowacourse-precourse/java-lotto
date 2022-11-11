package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Stream;

public class BonusInput {
    public static String bonusInput;
    public static int bonusNumber;
    public static boolean bonus;

    public static void bonusNumberInput() {
        System.out.println(Message.BONUS_NUMBER_INPUT.getMessage());
        bonusInput = readLine();
        validateInputBonusNumber(bonusInput);
    }

    public static void getBonusResult(List<List<Integer>> lottos) {
        bonusNumber = bonusToInt(bonusInput);
        bonus = false;
        for (List<Integer> check : lottos) {
            if (check.contains(bonusNumber)) {
                bonus = true;
            }
        }
    }

    public static int bonusToInt(String bonusInput) {
        bonusNumber = Integer.parseInt(bonusInput);
        return bonusNumber;
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
