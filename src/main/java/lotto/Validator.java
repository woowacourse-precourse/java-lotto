package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Validator {

    private final int startNum = 1;
    private final int endNum = 45;
    public List<Integer> winningNumberValidate(String winningNumber){
        winningNumber = winningNumber.replace(" ", "");
        String[] split = winningNumber.split(",");
        List<String> numbers = Arrays.asList(split);
        if (!checkNumber(numbers)){
            throw new IllegalArgumentException();
        }
        return toIntegerList(numbers);
    }

    private List<Integer> toIntegerList(List<String> split){
        ArrayList<Integer> winningNumber = new ArrayList<>();
        for (String s : split) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    private boolean checkNumber(List<String> numbers){
        for (String number : numbers) {
            if (!isRange(number)) return false;
        }
        if (!duplicateCheck(numbers)) return false;
        return true;
    }

    private boolean duplicateCheck(List<String> numbers) {
        for (String number : numbers) {
            int frequency = Collections.frequency(numbers, number);
            if (frequency > 1) return false;
        }
        return true;
    }
    private boolean isRange(String number){
        Integer n = stringTointeger(number);
        if (n < startNum || n > endNum){
            return false;
        }
        return true;
    }

    private Integer stringTointeger(String number){
        return Integer.parseInt(number);
    }

    public Integer moneyValidate(String money){
        if (!isMoney(money)){
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(money);
    }

    private boolean isMoney(String money){
        char[] chars = money.toCharArray();
        for (char c : chars) {
            if(!isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c){
        if (c < '0' && c > '9'){
            return false;
        }
        return true;
    }
}
