package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LuckySix {
    //public static List<Integer> luckySix;
    public static Lotto luckySix;

    public LuckySix(String inputLuckySix) {
        validateInteger(inputLuckySix);
        List<Integer> tempLuckySix = convertSixType(inputLuckySix);
        //validateAsLotto(tempLuckySix);
        //luckySix = tempLuckySix;
        luckySix = new Lotto(tempLuckySix);
    }

    /*private void validateAsLotto(List<Integer> tempLuckySix) {
        Lotto luckySixAsLotto = new Lotto(tempLuckySix);
    }*/

    private void validateInteger(String inputLuckySix) {
        for (int index = 0; index < inputLuckySix.length(); index++) {
            char oneNumber = inputLuckySix.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException(GameMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private List<Integer> convertSixType(String inputLuckySix) {
        List<Integer> tempLuckySix = new ArrayList<>();
        for (int index = 0; index < inputLuckySix.length(); index++) {
            char oneNumber = inputLuckySix.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            tempLuckySix.add(Character.getNumericValue(oneNumber));
        }
        return tempLuckySix;
    }

}
