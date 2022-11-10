package lotto.view;

import lotto.utils.ConsoleLog;
import lotto.validation.InputValidation;

import java.util.Arrays;
import java.util.Optional;

public class InputConsole {
    private static final ConsoleLog consolelog = ConsoleLog.getInstance();
    private static final String LINE = "\r\n";

    public String enterWinningNumber() {
        consolelog.println(LINE + "당첨 번호를 입력해 주세요.");
        String input = consolelog.input();
        checkValidation(input, "enterWinningNumber");
        return input;
    }

    public String enterBonusNumber() {
        consolelog.println(LINE + "보너스 번호를 입력해 주세요.");
        String input = consolelog.input();
        checkValidation(input, "enterBonusNumber");
        return input;
    }

    public String enterPurchaseAmount() {
        consolelog.println("구입금액을 입력해 주세요.");
        String input = consolelog.input();
        checkValidation(input, "enterPurchaseAmount");
        return input;
    }

    private void checkValidation(String input, String validationGroup) {
        Optional<InputValidation> validation = Arrays.stream(InputValidation.values())
                .filter(enumType -> enumType.getGroup().contains(validationGroup))
                .filter(enumType -> enumType.validate(input))
                .findFirst();

        if (validation.isPresent()) {
            throw new IllegalArgumentException(validation.get().errorMessage());
        }
    }
}
