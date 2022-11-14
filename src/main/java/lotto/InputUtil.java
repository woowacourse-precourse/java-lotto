package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputUtil {

    public static final String ERROR_INVALID_INPUT = "[ERROR] Invalid Input";

    public Integer inputNumber() {
        Integer outcome;

        String number = Console.readLine();
        checkValidity(number);
        outcome = Integer.parseInt(number);
        return outcome;
    }
    public ArrayList<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();
        ArrayList<Integer> checkedNumbers = checkNumbersValidity(numbers);
        return checkedNumbers;
    }
    private void checkValidity(String target) throws IllegalArgumentException{

    }
    private ArrayList<Integer> checkNumbersValidity(String target) throws IllegalArgumentException{

    }
}
