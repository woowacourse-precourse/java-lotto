package lotto.domain.view;

import static lotto.domain.model.ErrorMessage.INPUT_NULL;
import static lotto.domain.model.ErrorMessage.getErrorMessage;
import static lotto.domain.view.IOMessage.INPUT_DESIGNATE_BONUS;
import static lotto.domain.view.IOMessage.INPUT_DESIGNATE_FIRSTPLCAE;
import static lotto.domain.view.IOMessage.INPUT_PURCHASE_LOTTO;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputData {
    public static String purchaseLotto() {
        System.out.println(INPUT_PURCHASE_LOTTO.getMessage());
        return inputData();
    }

    public static String designateFirstPlace() {
        System.out.println(INPUT_DESIGNATE_FIRSTPLCAE.getMessage());
        return inputData();
    }

    public static String designateBonus() {
        System.out.println();
        System.out.println(INPUT_DESIGNATE_BONUS.getMessage());
        return inputData();
    }

    private static String inputData() {
        String inputData = Console.readLine();
        validate(inputData);
        return inputData;
    }

    private static void validate(final String inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException(getErrorMessage(INPUT_NULL));
        }
    }
}
