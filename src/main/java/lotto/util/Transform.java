package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    public List<String> splitLottoNumbers(String input) {
        String[] splitedInput = input.split(",");
        List<String> numbers = new ArrayList<>(List.of(splitedInput));
        return numbers;
    }

    public List<Integer> transformType(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
