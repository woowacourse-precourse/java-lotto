package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public static List<Integer> luckySix = new ArrayList<>();
    public static int luckyBonus;

    public static void pickSixNumber() {
        System.out.println(GameMessage.LUCKY_NUMBER_MESSAGE.getMessage());
        String inputSixNumber = Console.readLine();
        for (int index = 0; index < inputSixNumber.length(); index++) {
            char oneNumber = inputSixNumber.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
            luckySix.add(Character.getNumericValue(oneNumber));
        }
        Lotto luckyNumbers = new Lotto(luckySix);
    }

    public static void pickBonusNumber() {
        System.out.println(GameMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String inputBonusNumber = Console.readLine();
        for (int index = 0; index < inputBonusNumber.length(); index++) {
            if (!Character.isDigit(inputBonusNumber.charAt(index))) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
            if (index == 1) {
                throw new IllegalArgumentException(GameMessage.BONUS_ERROR_MESSAGE.getMessage());
            }
            if (luckySix.contains(Character.getNumericValue(inputBonusNumber.charAt(index)))) {
                throw new IllegalArgumentException(GameMessage.LUCKY_DUPLICATE_ERROR_MESSAGE.getMessage());
            }
            luckyBonus = Character.getNumericValue(inputBonusNumber.charAt(index));
        }
    }

}
