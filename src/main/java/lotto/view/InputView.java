package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getPurchase() throws NumberFormatException{
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getWinningNumber() throws NumberFormatException{
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for (String s : splitInput) {
            winningNumber.add(Integer.parseInt(s));
        }
        return  winningNumber;
    }

    public static int getBonusNumber() throws NumberFormatException{
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
