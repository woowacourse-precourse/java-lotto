package lotto;

import java.util.Arrays;

public class WinNumInputException {
    public static void winNumFormatError(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
    }

    public static void winNumTypeError(String input) {
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
    }

    public static void winNumRangeError(int number) {
        if (number < 0 || number > 45)
            throw new IllegalArgumentException("[ERROR] 1~45의 숫자를 입력해야 합니다.");
    }

    public static void winNumDuplicate(String[] input) {
        if (input.length != Arrays.stream(input).distinct().count())
            throw new IllegalArgumentException("[ERROR] 중복된 수를 입력하였습니다.");
    }
    public static void winNumSizeError(String[] input){
        if(input.length!=6)
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
    }
}
