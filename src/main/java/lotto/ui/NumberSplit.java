package lotto.ui;

import java.util.ArrayList;
import java.util.List;

public class NumberSplit {
    List<Integer> number = new ArrayList<>();
    public NumberSplit(String userNumbers) {
        String[] numberSplit = userNumbers.split(",");

        for (int i = 0; i < numberSplit.length; i++) {
            number.add(Integer.valueOf(numberSplit[i]));
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
