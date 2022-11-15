package lotto.Utils.Validator;

import lotto.View.OutputView;

public class IntegerValidator {
    private static final String ERROR_MESSAGE="[ERROR] 입력값에 정수가 아닌 부분이 있습니다.";


    public static void Integer(String string) {
        if (!string.matches("-?\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
