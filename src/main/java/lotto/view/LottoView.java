package lotto.view;

import static lotto.LottoConstant.GAME_START_MESSAGE;
import static lotto.LottoConstant.PURCHASE_LOTTO_COUNT_RESULT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;

public class LottoView {

    private LottoView() {
    }

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static String getLottoPurchaseAmount() {
        return Console.readLine();
    }

    public static void printLottoPurchaseResult(int purchaseAmount, List<Lotto> lottoNumbers) {
        System.out.println(purchaseAmount + PURCHASE_LOTTO_COUNT_RESULT_MESSAGE);
        lottoNumbers.forEach(System.out::println);
    }

    public static String getWinningNumber() {
        return Console.readLine();
    }
}
