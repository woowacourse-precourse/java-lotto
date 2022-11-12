package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.ErrorMessage;

public class BonusInput {
    private static int bonusNumber;
    public static String bonusInput;
    public static boolean bonus;

    public static void bonusNumberInput() {
        System.out.println(Message.BONUS_NUMBER_INPUT.getMessage());
        bonusInput = readLine();
        validateInputBonusNumber(bonusInput);
        System.out.println();
    }

    public static void getBonusResult(List<List<Integer>> lottos) {
        bonusNumber = bonusToInt(bonusInput);
        bonus = false;
        for (List<Integer> check : lottos) {
            if (check.contains(bonusNumber)) {
                bonus = true;
                break;
            }
        }
    }

    private static int bonusToInt(String bonusInput) {
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
