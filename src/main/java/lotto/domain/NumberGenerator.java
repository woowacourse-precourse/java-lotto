package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static List<Integer> numbers;
    private static final String regex = "^\\d,\\d,\\d,\\d,\\d,\\d$";

    public NumberGenerator() {
    }
    
    public NumberGenerator(int start, int end, int count) {
        numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public void setWinningNumber() {
        String input = inputWinningNumber();
        validate(input);
        String[] inputNumber = splitStr(input);
        numbers = new ArrayList<>();
        for(int i = 0; i < inputNumber.length; i++) {
            numbers.add(Integer.parseInt(inputNumber[i]));
        }
    }
    
    private String inputWinningNumber() {
        return Console.readLine();
    }
    
    private void validate(String str) {
        if(!str.matches(regex)) {
            throw new IllegalArgumentException();
        }
        String[] inputNumber = splitStr(str);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < inputNumber.length; i++) {
            set.add(Integer.parseInt(inputNumber[i]));
        }
        if(set.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(Integer i : set) {
            if(i < 1 || i > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    private String[] splitStr(String str) {
        String[] inputNumber = str.split(",");
        return inputNumber;
    }
}
