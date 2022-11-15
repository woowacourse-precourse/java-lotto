package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constant;
import lotto.utils.ErrorMessage;
import lotto.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionService;

public class Input {
    private static final Integer REMAINDER = 0;

    public static Integer getPurchaseAmount() {
        String input = Console.readLine();

        Validation.checkTypeNumber(input);
        return validatePurchaseAmount(toInts(input));
    }

    public static Integer validatePurchaseAmount(int amount) {
        if (!(amount % Constant.PURCHASE_AMOUNT_UNIT == REMAINDER)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR.getMessage());
        }
        return amount;
    }

    private static Integer toInts(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> validateWiningNumber(String winingNumber) {
        String[] splits = winingNumber.split(",");
        List<Integer> numbers = new ArrayList<>();

        Validation.checkSplitLength(splits.length);

        for (String split : splits) {
            numbers.add(Integer.parseInt(split));
        }

        Validation.checkNumberRange(numbers);
        Validation.checkDuplicatedNumber(numbers);

        return numbers;
    }

    public static List<Integer> getWiningNumber() {
        String winingNumber = Console.readLine();

        return validateWiningNumber(winingNumber);
    }

    public static Integer validateBonusNumber(String bonusNumber) {
        String[] splits = bonusNumber.split(" ");
        Validation.checkBonusNumberLength(splits.length);

        List<Integer> number = new ArrayList<>(Arrays.asList(Integer.parseInt(splits[0])));
        Validation.checkNumberRange(number);

        return number.get(0);
    }

    public static Integer getBonusNumber() {
        return validateBonusNumber(Console.readLine());
    }
}
