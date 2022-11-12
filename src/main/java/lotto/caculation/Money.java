package lotto.caculation;

import lotto.utils.Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {
    private static final Pattern CORRECT_MONEY_PATTERN = Pattern.compile("^[0-9]*$");

    private int money;

    private void checkPattern(String input){
        Matcher matcher = CORRECT_MONEY_PATTERN.matcher(input);
        if(!matcher.find()){
            throw new IllegalArgumentException(Exception.catchException());
        }
    }
}
