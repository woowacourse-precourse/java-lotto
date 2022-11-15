package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MSG);
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MSG);
        String input = Console.readLine();
        String[] inputSplit = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int cnt = 0; cnt < COUNT_NUM; cnt++){
            winningNumbers.add(Integer.parseInt(inputSplit[cnt]));
        }
        return winningNumbers;
    }

    public static String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
