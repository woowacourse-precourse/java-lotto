package lotto.Number;

import lotto.Machine.PrintMachine;

public class NumValidate {

    public static void validateInteger(String string) {
        if (!string.matches("-?\\\\d+")) {
            PrintMachine.errorMessage("입력값이 옳지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(String StringNumber) {
        int number = Integer.parseInt(StringNumber);
        if (!(number > 0 && number < 46)) {
            PrintMachine.errorMessage("입력값의 범위가 맞지 않습니다..");
            throw new IllegalArgumentException();
        }
    }
}
