package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.InputString.*;

public class InputView {
    public int inputMoney(){
        System.out.println(PURCHASE_MONEY_MESSAGE);
        return checkAndConvertToInt(Console.readLine());
    }
    
    private int checkAndConvertToInt(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_NUMBER_INPUT.toString());
        }
    }

    private void checkIntAndComma(String input){
        String pattern = "[0-9,]+";
        if (!Pattern.matches(pattern, input)){
            throw new IllegalArgumentException(NO_NUMBER_AND_COMMA_INPUT.toString());
        }
    }

    private List<Integer> convertToListInt(String input){
        List<String> temp = Stream.of(input.split("\\s*,\\s*")).collect(Collectors.toList());
        List<Integer> conversion = temp.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return conversion;
    }
}
