package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 로또 구매를 하고, 당첨 번호를 입력받고, 통계를 출력해주는 전체 과정을 다루는 시스템
 */
public final class LottoWinningSystem {
    private static final String NULL_INPUT_VIEW = "InputView 에 null 이 들어왔습니다";
    private static final String NULL_OUTPUT_VIEW = "OutputView 에 null 이 들어왔습니다";
    private static final String NULL_PICK_NUMBERS = "PickNumbers 에 null 이 들어왔습니다";
    private final InputView inputView;
    private final OutputView outputView;
    private final PickNumbers pickNumbers;

    /**
     * 생성 시에 null 이 들어오면 IEA 예외가 발생한다
     *
     * @param inputView   사용자로부터 입력을 담당하는 view
     * @param outputView  사용자한테 출력을 담당하는 view
     * @param pickNumbers 숫자들을 골라주는 클래스
     */
    public LottoWinningSystem(InputView inputView, OutputView outputView, PickNumbers pickNumbers) {
        validateInput(inputView);
        validateOutput(outputView);
        validatePickNumbers(pickNumbers);
        this.inputView = inputView;
        this.outputView = outputView;
        this.pickNumbers = pickNumbers;
    }

    private void validateInput(InputView inputView) {
        if (inputView == null) {
            throw new IllegalArgumentException(NULL_INPUT_VIEW);
        }
    }

    private void validateOutput(OutputView outputView) {
        if (outputView == null) {
            throw new IllegalArgumentException(NULL_OUTPUT_VIEW);
        }
    }

    private void validatePickNumbers(PickNumbers pickNumbers) {
        if (pickNumbers == null) {
            throw new IllegalArgumentException(NULL_PICK_NUMBERS);
        }
    }

    /**
     * 구매, 당첨번호 입력, 통계까지의 과정을 1회 진행함
     */
    public void run() {
        final Money money = getPlayerMoney();

        final Lottos lottos = generateLottos(money);

        final WinningLotto winningLotto = createWinningLottery();

        final LottoStatistic lottoStatistic = new LottoStatistic(winningLotto, lottos);
        final LottoScoreDto lottoScoreDto = lottoStatistic.calculateStatistic();
        outputView.printStatistic(lottoScoreDto);
    }

    private Money getPlayerMoney() {
        outputView.printInputAmount();
        final Money money = new Money(inputView.inputLong());
        outputView.printLottoAmountMessage(money);
        return money;
    }

    private Lottos generateLottos(Money money) {
        final Lottos lottos = new LottoCreator(pickNumbers).createLottos(money);
        outputView.printLottos(lottos);
        return lottos;
    }

    private WinningLotto createWinningLottery() {
        outputView.printInputLotteryMessage();
        final Lotto winLotto = new Lotto(inputView.inputListIntegers());

        outputView.printInputBonusMessage();
        final BonusNumber bonusNumber = new BonusNumber(inputView.inputInt());

        return new WinningLotto(winLotto, bonusNumber);
    }
}
