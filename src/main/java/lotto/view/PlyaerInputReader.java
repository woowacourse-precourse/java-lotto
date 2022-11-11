package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.uitls.Validation.validateLottoPurchaseAmount;

public class PlyaerInputReader {

    public int readAmountOfLottoPrice() {
        String playerInput = readLine();
        validateLottoPurchaseAmount(playerInput);
        return Integer.parseInt(playerInput);
    }
}
