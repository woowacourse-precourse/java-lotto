package lotto.model;

import lotto.model.enums.ErrorMessage;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class LuckySix {
    public static Lotto luckySix;

    public LuckySix(String inputLuckySix) {
        validateSixNumber(inputLuckySix);
        List<Integer> tempLuckySix = convertLuckySixType(inputLuckySix);
        luckySix = new Lotto(tempLuckySix);
    }

    private void validateSixNumber(String inputLuckySix) {
        try {
            Validator.validateSixNumber(inputLuckySix);
        } catch (IllegalArgumentException integerError) {
            ErrorMessage.SIX_ERROR_MESSAGE.printMessage();
            throw integerError;
        }
    }

    private List<Integer> convertLuckySixType(String inputLuckySix) {
        String[] tempInputLuckySix = inputLuckySix.split(",");
        List<Integer> tempLuckySix = new ArrayList<>();
        for (String luckyOne : tempInputLuckySix) {
            tempLuckySix.add(Integer.parseInt(luckyOne));
        }
        return tempLuckySix;
    }
}
