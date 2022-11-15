package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionCase {
    private static boolean checkInputSameNumber(List<Integer> input) {
        Set<Integer> inputRemoveSameNumber = new HashSet<>(input);

        if (inputRemoveSameNumber.size() != 6) {
            Display.displayErrorSameNumber();
            return false;
        }

        return true;
    }

    private static boolean checkInputSameNumber(List<Integer> winSixNumber, String input) {
        if (winSixNumber.contains(Integer.parseInt(input))) {
            Display.displayErrorSameNumber();
            return false;
        }

        return true;
    }

    private static boolean checkInputAllNumber(String input) {

        char separate = ' ';

        for (int i = 0; i < input.length(); i++) {
            separate = input.charAt(i);

            if (Character.isDigit(separate) == false) {
                Display.displayErrorOnlyNumber();
                return false;
            }
        }

        return true;
    }

    private static boolean checkDivideThousand(String input) {

        if (Integer.parseInt(input) % 1000 == 0) {
            Display.displayErrorMoney();
            return true;
        }

        return false;
    }

    static boolean checkBoundLottoNumber(List<Integer> input) {

        for (int i = 0; i < input.size(); i++) {
            if (!(input.get(i) > 0 && input.get(i) < 46)) {
                Display.displayErrorBound();
                return false;
            }
        }

        return true;
    }

    static boolean checkBoundLottoNumber(String input) {
        int bonusNumber = Integer.parseInt(input);

        if (!(bonusNumber > 0 && bonusNumber < 46)) {
            Display.displayErrorBound();
            return false;
        }

        return true;
    }

    static public void checkInputMoney(String input) {
        if (!checkInputAllNumber(input)) {
            throw new IllegalArgumentException();
        }
        if (!checkDivideThousand(input)) {
            throw new IllegalArgumentException();
        }
    }

    static public void checkInputLottoNumber(List<Integer> input) {
        if (!checkInputSameNumber(input)) {
            throw new IllegalArgumentException();
        }
        if (!checkBoundLottoNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    static public void checkInputBonusNumber(List<Integer> winSixNumber, String input) {
        if (!checkInputAllNumber(input)) {
            throw new IllegalArgumentException();
        }
        if (!checkInputSameNumber(winSixNumber, input)) {
            throw new IllegalArgumentException();
        }
        if (!checkBoundLottoNumber(input)) {
            throw new IllegalArgumentException();
        }
    }


}
