package lotto.view;

import handler.OutputHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreDto;
import lotto.domain.Lottos;
import lotto.domain.Money;

/**
 * 사용자한테 출력을 OutputHandler 를 통해서 하는 view
 */
public final class OutputView {
    private static final String NULL_MESSAGE = "OutputHandler 가 null 입니다";
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_AMOUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_LOTTERY_MESSAGE = "\n 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "\n 보너스 번호를 입력해 주세요.";
    private static final String STATISTIC_TITLE = "\n당첨 통계";
    private static final String LINE_FEED = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String RATE = "총 수익률은 %.1f%%입니다.\n";
    private final OutputHandler outputHandler;

    /**
     * 생성 시 null 이 들어오면 IEA 예외
     *
     * @param outputHandler null 이 아닌 출력을 할 outputHandler 의 구상클래스
     */
    public OutputView(OutputHandler outputHandler) {
        validateOutputHandler(outputHandler);
        this.outputHandler = outputHandler;
    }

    private void validateOutputHandler(OutputHandler outputHandler) {
        if (outputHandler == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    /**
     * 사용자에게 구매 금액을 입력하라는 메시지를 보낸다
     */
    public void printInputAmount() {
        outputHandler.println(INPUT_AMOUNT_MESSAGE);
    }

    /**
     * 사용자에게 몇 개를 구매했는지를 보낸다
     *
     * @param money 사용자가 사용한 금액
     */

    public void printLottoAmountMessage(Money money) {
        outputHandler.printf(LOTTO_AMOUNT_MESSAGE, money.ableToBuy());
    }

    /**
     * 사용자에게 뽑힌 로또를 출력해준다
     *
     * @param lottos 로또들에 대한 정보
     */
    public void printLottos(Lottos lottos) {
        lottos.toStream().forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        outputHandler.println(lotto.toPrintableFormat());
    }

    /**
     * 사용자에게 당첨 번호를 입력하라는 메시지를 출력한다
     */
    public void printInputLotteryMessage() {
        outputHandler.println(INPUT_LOTTERY_MESSAGE);
    }

    /**
     * 사용자로부터 보너스 넘버를 입력하라는 메시지를 출력한다
     */
    public void printInputBonusMessage() {
        outputHandler.println(INPUT_BONUS_MESSAGE);
    }

    /**
     * 사용자에게 통계 결과를 출력합니다
     *
     * @param scoreDto 통계 데이터를 담고 있는 dto 객체
     */
    public void printStatistic(LottoScoreDto scoreDto) {
        outputHandler.println(STATISTIC_TITLE);
        outputHandler.println(LINE_FEED);
        outputHandler.printf(THREE_CORRECT, scoreDto.fifthPrizeCount());
        outputHandler.printf(FOUR_CORRECT, scoreDto.fourthPrizeCount());
        outputHandler.printf(FIVE_CORRECT, scoreDto.thirdPrizeCount());
        outputHandler.printf(FIVE_BONUS_CORRECT, scoreDto.secondPrizeCount());
        outputHandler.printf(SIX_CORRECT, scoreDto.firstPrizeCount());
        outputHandler.printf(RATE, scoreDto.getRate());
    }
}
