package Utils;

import java.util.Collections;
import java.util.List;

public class InputUtils {
    public static boolean isMultipleOfOneThousand(String input) {
        // 1000원 단위로 떨어지는지 검증
        final int THOUSAND_WON = 1000;
        int number = Integer.parseInt(input);
        return number % THOUSAND_WON == 0;
    }

    public static boolean isNumberLengthSix(List<Integer> input) {
        // 당첨 번호가 6자리인지 확인
        return input.size() == 6;
    }

    public static boolean isNumberSplitWithComma(String input) {
        // 당첨 번호가 쉼표로 구분되어 있는지
        return false;
    }

    public static boolean isDigit(String input) {
        // 정수 이외의 다른 문자 값을 입력하였는지 확인
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumberInLottoRange(String input) {
        // 숫자가 1~45 사이의 범위에 존재하는지 확인
        final int startNumber = 1;
        final int endNumber = 2;
        int number = Integer.parseInt(input);
        return number >= startNumber  && number <= endNumber;
    }

    public static String listToString(List<Integer> list) {
        return "";
    }

    public static int stringToInteger(String string) {
        return 0;
    }

    public static List<Integer>  stringToIntegerList(String string) {
        return Collections.emptyList(); 
    }
}
