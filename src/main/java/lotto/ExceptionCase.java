package lotto;

import java.util.*;

public class ExceptionCase {
    private static boolean checkInputSameNumber(List<Integer> input) {
        Set<Integer> inputRemoveSameNumber = new HashSet<>(input);

        if (inputRemoveSameNumber.size() != 6) {
            return false;
        }

        return true;
    }

    private static boolean checkInputAllNumber(String input) {

        char separate = ' ';

        for (int i = 0; i < input.length(); i++) {
            separate = input.charAt(i);

            if (Character.isDigit(separate) == false) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkDivideThousand(String input) {

        if (Integer.parseInt(input) % 1000 == 0) {
            return true;
        }

        return false;
    }

    static boolean checkBoundLottoNumber (List<Integer> input) {

        for (int i = 0; i < input.size(); i++) {
            if (!(input.get(i) > 0 && input.get(i) < 46)) {
                return false;
            }
        }

        return true;
    }

    static public void checkInputLottoNumber(List<Integer> input) {
        if (!checkInputSameNumber(input)) {
            throw new IllegalArgumentException();
        }
        if (!checkBoundLottoNumber(input)) {
            throw new IllegalArgumentException();
        }
    }
}
