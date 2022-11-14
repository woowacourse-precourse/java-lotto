package lotto.datamodel.util;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    public Transform() {
    }

    public List<Integer> numberTransform(String input) {
        String[] numbers = input.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            winNumbers.add(Integer.parseInt(number));
        }
        return winNumbers;
    }

    public int bonusTransform(String input) {
        return Integer.parseInt(input);
    }
}
