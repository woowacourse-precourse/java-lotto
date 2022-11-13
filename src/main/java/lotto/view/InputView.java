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

}
