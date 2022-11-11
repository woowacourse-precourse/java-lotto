package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getPurchase() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinningNumber() {
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for (String s : splitInput) {
            winningNumber.add(Integer.parseInt(s));
        }
        return  winningNumber;
    }
}
