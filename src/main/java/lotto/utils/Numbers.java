package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    public static List<Integer> sortAscending(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);

        return numbers;
    }
}
