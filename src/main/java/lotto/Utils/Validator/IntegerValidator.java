package lotto.Utils.Validator;

import lotto.View.OutputView;

public class IntegerValidator {

    public static void Integer(String string) {
        if (!string.matches("-?\\d+")) {
            OutputView.errorMessage("입력값이 옳지 않습니다.");
            throw new IllegalArgumentException();
        }
    }
}
