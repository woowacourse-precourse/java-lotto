package lotto.model;

import lotto.model.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LuckySix {
    public Lotto luckySix;

    public LuckySix(String inputLuckySix) {
        validateInvalidInput(inputLuckySix);
        validateSixNumber(inputLuckySix);
        List<Integer> luckySix = convertLuckySixType(inputLuckySix);
        this.luckySix = new Lotto(luckySix);
    }

    private static void validateInvalidInput(String inputLuckySix) {
        try {
            String[] separateInputLuckySix = inputLuckySix.split(",");
            for (String oneNumber : separateInputLuckySix) {
                int checkValue = Integer.parseInt(oneNumber);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateSixNumber(String inputLuckySix) {
        for (int index = 0; index < inputLuckySix.length(); index++) {
            char oneNumber = inputLuckySix.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException(ErrorMessage.SIX_ERROR_MESSAGE.getMessage());
            }
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
