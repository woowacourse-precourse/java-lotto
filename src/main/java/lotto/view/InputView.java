package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Validation.validateLottoPurchaseAmount;
import static lotto.utils.Validation.validateLottoWinningNumber;
import static lotto.utils.Converter.convertToIntegerList;

public class InputView {

    public static int readAmountOfLottoPrice() {
        String playerInput = readLine();
        validateLottoPurchaseAmount(playerInput);
        return Integer.parseInt(playerInput);
    }

    public static List<Integer> readWinningNumbers() {
        String playerInput = readLine();
        validateLottoWinningNumber(playerInput);
        return convertToIntegerList(playerInput);
    }
}
