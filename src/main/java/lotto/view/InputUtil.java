package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    public static final String ERROR_INVALID_INPUT = "[ERROR] Invalid Input";

    public static  Integer inputNumber() {
        Integer outcome;

        String number = Console.readLine();
        try{
            checkValidity(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        outcome = Integer.parseInt(number);
        return outcome;
    }
    public static List<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();
        List<Integer> checkedNumbers = checkNumbersValidity(numbers);
        return checkedNumbers;
    }
    private static void checkValidity(String target) throws IllegalArgumentException{
        char[] words = target.toCharArray();
        for(char word : words){
            if(!Character.isDigit(word)){
                throw new IllegalArgumentException(ERROR_INVALID_INPUT);
            }
        }
    }
    private static ArrayList<Integer> checkNumbersValidity(String target) throws IllegalArgumentException{
        ArrayList<Integer> outcome = new ArrayList<>();
        String[] parsedTarget = target.split(",");
        for(String word : parsedTarget){
            Integer number;

            checkValidity(word);
            number=Integer.parseInt(word);
            outcome.add(number);
        }
        return outcome;
    }
}
