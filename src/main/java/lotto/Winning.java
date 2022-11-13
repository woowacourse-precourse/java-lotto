package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    public Winning() {
    }

    public static List<Integer> makeWinningNumberList(String userInput) {
        String[] numbers = userInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String num : numbers) {
            winningNumbers.add(Integer.parseInt(num));
        }

        return winningNumbers;
    }
}
