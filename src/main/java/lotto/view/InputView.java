package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Validation.validateLottoPurchaseAmount;
import static lotto.utils.Validation.validateLottoWinningNumber;
import static lotto.utils.Validation.validateLottoBonusNumber;
import static lotto.utils.Converter.convertToIntegerList;

public class InputView {

    public static int readAmountOfLottoPrice() {
        String playerInput = readLine();
        validateLottoPurchaseAmount(playerInput);
        System.out.println();
        return Integer.parseInt(playerInput);
    }

    public static List<Integer> readWinningNumbers() {
        String playerInput = readLine();
        validateLottoWinningNumber(playerInput);
        System.out.println();
        return convertToIntegerList(playerInput);
    }

    public static int readBonusNumber() {
        String playerInput = readLine();
        validateLottoBonusNumber(playerInput);
        System.out.println();
        return Integer.parseInt(playerInput);
    }
}
