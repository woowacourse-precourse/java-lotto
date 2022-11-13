package lotto;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class InputException {
    static final int DIVIDENUMBER = 1000;

    public static void isValidNumber(String inputString) {
        ParsePosition parsePosition = new ParsePosition(0);
        NumberFormat.getInstance().parse(inputString, parsePosition);
        try {
            if (inputString.length() != parsePosition.getIndex()) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            throw illegalArgumentException;
        }
    }

    public static void isValidDivide(int input) {
        if (input % DIVIDENUMBER != 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                throw illegalArgumentException;
            }
        }
    }
}
