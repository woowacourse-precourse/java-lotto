package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.InputString.*;

public class InputView {

    public static int inputMoney(){
        System.out.println(PURCHASE_MONEY_MESSAGE);
        return checkAndConvertToInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumber(){
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        checkIntAndComma(input);
        return convertToListInt(input);
    }

    public static int inputBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        return checkAndConvertToInt(Console.readLine());
    }
    
    private static int checkAndConvertToInt(String input){
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(NO_NUMBER_INPUT.toString());
            //throw new IllegalArgumentException(NO_NUMBER_INPUT.toString());
            throw new NoSuchElementException();
        }
    }

    private static void checkIntAndComma(String input){
        String pattern = "[0-9,]+";
        if (!Pattern.matches(pattern, input)){
            throw new IllegalArgumentException(NO_NUMBER_AND_COMMA_INPUT.toString());
        }
    }

    private static List<Integer> convertToListInt(String input){
        List<String> temp = Stream.of(input.split("\\s*,\\s*")).collect(Collectors.toList());
        List<Integer> conversion = temp.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return conversion;
    }
}
