package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static List<Integer> numbers;

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
        String[] inputNumber = splitStr(input);
        numbers = new ArrayList<>();
        for(int i = 0; i < inputNumber.length; i++) {
            numbers.add(Integer.parseInt(inputNumber[i]));
        }
    }
    
    private String inputWinningNumber() {
        return Console.readLine();
    }
    
    private String[] splitStr(String str) {
        String[] inputNumber = str.split(",");
        return inputNumber;
    }
}
