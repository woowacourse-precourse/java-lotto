package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

    private static final int LOTTO_SIZE = 6;

    public void isValidNumber(int number) {

    }

    public void isValidPrice(int price) {

    }

    public void isValidWinningNumbers(List<Integer> numbers) {

    }

    public void isValidSize(List<Integer> numbers) {

    }

    public void isValidWinningNumbersInput(String input) {

    }

    public void hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            System.out.println("[ERROR] 중복된 숫자가 존재합니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }
}
