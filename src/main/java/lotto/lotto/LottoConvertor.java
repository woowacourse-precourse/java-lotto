package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.input.Input;

public class LottoConvertor {
    private static final Input input = new Input();

    public String[] splitNumbers(String input) { // 입력한 값을 String 배열로 넘긴다.
        return input.split(",");
    }

    public List<Integer> convertNumbers(String[] numbers) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            winNumbers.add(input.convertInput(number));
        }
        return winNumbers;
    }
}
