package lotto.util;

import static lotto.util.Message.WRONG_INPUT;

import java.util.*;
import java.util.regex.Pattern;

public class Validator {
    private static final String MONEY_PATTERN = "^[0-9]*$";
    private static final int MONEY_UNIT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int TOTAL_NUMBER = 6;
    private static final String STRING_TOKEN = ",";

    private List<Integer> list = new LinkedList<>();

    public void moneyValid(String input){
        isNumber(input);
        isDivided(input);
    }

    private void isNumber(String input){
        if(!Pattern.matches(MONEY_PATTERN, input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private void isDivided(String input){
        if(Integer.parseInt(input) % MONEY_UNIT != 0)
            throw new IllegalArgumentException(WRONG_INPUT);
    }
}
