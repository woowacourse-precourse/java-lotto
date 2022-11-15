package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Calculate.getWinningDetails;
import static lotto.Input.*;
import static lotto.Lotto.purchaseLottos;
import static lotto.Output.printLottoWinningDetails;
import static lotto.Output.printPurchasedLotto;
import static lotto.Validation.*;

public class LottoProgram {

    public static void runLottoProgram() {
        long purchaseAmount = getPurchaseAmount();

        List<Lotto> lottos = purchaseLottos(purchaseAmount);
        printPurchasedLotto(purchaseAmount, lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        printLottoWinningDetails(purchaseAmount, getWinningDetails(lottos, winningNumbers, bonusNumber));
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberString = enterLottoBonusNumber();
        validateBonusNumber(winningNumbers, bonusNumberString);
        return Integer.parseInt(bonusNumberString);
    }

    public static long getPurchaseAmount() {
        String purchaseAmountString = enterLottoPurchaseAmount();
        validateLottoPurchaseAmount(purchaseAmountString);
        return Long.parseLong(purchaseAmountString);
    }

    public static List<Integer> getWinningNumbers() {
        String winningNumbersWithComma = enterLottoWinningNumbers();
        validateWinningNumbers(winningNumbersWithComma);
        return Arrays.stream(winningNumbersWithComma.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
