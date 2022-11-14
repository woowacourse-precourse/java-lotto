package lotto.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;
import lotto.input.Input;

public class LottoValidator {
    private static final Input input = new Input();

    public String[] splitNumbers(String input) { // 입력한 값을 String 배열로 넘긴다.
        return input.split(",");
    }

    public List<Integer> convertNumbers(String[] numbers) { // String 배열을 List로 반환
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String number : numbers) {
            prizeNumbers.add(input.convertInput(number));
        }
        return prizeNumbers;
    }
}
