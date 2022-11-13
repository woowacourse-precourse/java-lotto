package lotto.view;

import handler.OutputHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreDto;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class OutputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_AMOUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_LOTTERY_MESSAGE = "\n 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "\n 당첨 번호를 입력해 주세요.";
    private static final String STATISTIC_TITLE = "\n당첨 통계";
    private static final String LINE_FEED = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String RATE = "총 수익률은 %.1f%%입니다.\n";
    private final OutputHandler outputHandler;

    public OutputView(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void printInputAmount() {
        outputHandler.println(INPUT_AMOUNT_MESSAGE);
    }

    public void printLottoAmountMessage(Money money) {
        outputHandler.printf(LOTTO_AMOUNT_MESSAGE, money.ableToBuy());
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        outputHandler.println(lotto.getLottoPrinting());
    }

    public void printInputLotteryMessage() {
        outputHandler.println(INPUT_LOTTERY_MESSAGE);
    }

    public void printInputBonusMessage() {
        outputHandler.println(INPUT_BONUS_MESSAGE);
    }

    public void printStatistic(LottoScoreDto scoreDto) {
        outputHandler.println(STATISTIC_TITLE);
        outputHandler.println(LINE_FEED);
        outputHandler.printf(THREE_CORRECT, scoreDto.getThree());
        outputHandler.printf(FOUR_CORRECT, scoreDto.getFour());
        outputHandler.printf(FIVE_CORRECT, scoreDto.getFive());
        outputHandler.printf(FIVE_BONUS_CORRECT, scoreDto.getFiveBonus());
        outputHandler.printf(SIX_CORRECT, scoreDto.getSix());
        outputHandler.printf(RATE, scoreDto.getRate());
    }
}
