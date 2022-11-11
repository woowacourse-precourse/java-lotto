package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    static final int START_RANGE = 1;
    static final int FINAL_RANGE = 45;
    static final int MAX_LEN = 6;

    public static int getPurchase() throws NumberFormatException {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinningNumber() throws NumberFormatException {
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for (String s : splitInput) {
            int number = Integer.parseInt(s);
            if (number > FINAL_RANGE || number < START_RANGE) {
                throw new NumberFormatException();
            }
            winningNumber.add(number);
        }
        if (winningNumber.size() != MAX_LEN) {
            throw new NumberFormatException();
        }
        return winningNumber;
    }

    public static int getBonusNumber() throws NumberFormatException {
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        if (number > FINAL_RANGE || number < START_RANGE) {
            throw new NumberFormatException();
        }
        return number;
    }
}
