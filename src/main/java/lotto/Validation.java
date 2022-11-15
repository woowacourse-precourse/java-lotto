package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

    private static final int LOTTO_SIZE = 6;

    public void isValidNumber(int number) {
        if(number < 1 || number > 45) {
            System.out.println("[ERROR] 1 ~ 45의 숫자가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 1 ~ 45의 숫자가 아닙니다.");
        }
    }

    public void isValidPrice(int price) {
   }

    public void isValidWinningNumbers(List<Integer> numbers) {
        isValidSize(numbers);
        for(int number: numbers) {
            isValidNumber(number);
        }
        hasDuplicateNumber(numbers);
    }

    public void isValidSize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE) {
            System.out.println("[ERROR] 6개의 숫자가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    public void isValidWinningNumbersInput(String input) {
        if(!Pattern.matches("^([0-9]+,){5}[0-9]+", input)){
            System.out.println("[ERROR] 올바른 형식의 입력이 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 올바른 형식의 입력이 아닙니다.");
        }
    }

    public void hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            System.out.println("[ERROR] 중복된 숫자가 존재합니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }
}
