package lotto;

import lotto.domain.*;
import lotto.utils.Input;
import lotto.utils.Output;

public class Application {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {
        Amount amount = inputAmount();
        int lottoCount = calculateLottoCount(amount);

        Lottos lottos = generatePurchasedLottos(lottoCount);

        Lotto winningLotto = inputWinningLotto();
        Bonus bonus = inputBonusNumber();

        Results results = lottos.generateResults(winningLotto, bonus);
        Statistics statistics = results.generateStatistics();

        Output.printTotalResult(statistics, amount);
    }

    private static Amount inputAmount() {
        Output.println(INPUT_AMOUNT_MESSAGE);
        return Input.inputAmount();
    }

    private static int calculateLottoCount(Amount amount) {
        int lottoCount = amount.calculateLottoCount();
        Output.println("\n" + lottoCount + LOTTO_COUNT_MESSAGE);
        return lottoCount;
    }

    private static Lottos generatePurchasedLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        lottos.generateLottos(lottoCount);

        Output.printPurchasedLottos(lottos.checkLottos());
        return lottos;
    }

    private static Lotto inputWinningLotto() {
        Output.println(INPUT_WINNING_NUMBERS_MESSAGE);
        Lotto winningLotto = Input.inputWinningNumbers();
        return winningLotto;
    }

    private static Bonus inputBonusNumber() {
        Output.println("\n" + INPUT_BONUS_NUMBER_MESSAGE);
        Bonus bonus = Input.inputBonusNumber();
        return bonus;
    }
}
