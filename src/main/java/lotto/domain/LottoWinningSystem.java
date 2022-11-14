package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoWinningSystem {
    private static final String NULL_INPUT_VIEW = "InputView 에 null 이 들어왔습니다";
    private static final String NULL_OUTPUT_VIEW = "OutputView 에 null 이 들어왔습니다";
    private static final String NULL_PICK_NUMBERS = "PickNumbers 에 null 이 들어왔습니다";
    private final InputView inputView;
    private final OutputView outputView;
    private final PickNumbers pickNumbers;

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
        final Money money = new Money(inputView.inputAmount());
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
        final Lotto winLotto = new Lotto(inputView.inputLotteryNumber());

        outputView.printInputBonusMessage();
        final BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());

        return new WinningLotto(winLotto, bonusNumber);
    }
}
