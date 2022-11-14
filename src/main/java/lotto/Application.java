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

        Output.println(INPUT_AMOUNT_MESSAGE);
        Amount amount = Input.inputAmount();
        int lottoCount = amount.calculateLottoCount();

        Output.println("\n" + lottoCount + LOTTO_COUNT_MESSAGE);

        // 로또 발행하는 부분
        Lottos lottos = new Lottos();
        lottos.generateLottos(lottoCount);

        // 발행된 로또 출력하는 부분
        Output.printPurchasedLottos(lottos.checkLottos());

        // 당첨 번호를 입력하는 부분
        Output.println(INPUT_WINNING_NUMBERS_MESSAGE);
        Lotto winningLotto = Input.inputWinningNumbers();

        Output.println("\n" + INPUT_BONUS_NUMBER_MESSAGE);
        Bonus bonus = Input.inputBonusNumber();

        Results results = new Results();

        // 결과 판정하는 부분
        for (Lotto lotto : lottos.getLottos()) {
            results.addResult(lotto.generateResult(winningLotto, bonus));
        }
        //  통계 만드는 부분
        Statistics statistics = new Statistics();

        for (Result result : results.getResults()) {
            Prize prize = Prize.generatePrize(result);
            statistics.updateStatistics(prize);
        }

        Output.printWinningStatistics(statistics);
        Output.printTotalYield(statistics, amount);
    }
}
