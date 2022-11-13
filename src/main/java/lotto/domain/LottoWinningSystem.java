package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoWinningSystem {
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
            throw new IllegalArgumentException();
        }
    }

    private void validateOutput(OutputView outputView) {
        if (outputView == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePickNumbers(PickNumbers pickNumbers) {
        if (pickNumbers == null) {
            throw new IllegalArgumentException();
        }
    }

    public void run() {
        Money money = getPlayerMoney();

        Lottos lottos = generateLottos(money);

        WinningLotto winningLotto = getWinningLottery();

        LottoStatistic lottoStatistic = new LottoStatistic(winningLotto, lottos);
        LottoScoreDto lottoScoreDto = lottoStatistic.getScore();
        outputView.printStatistic(lottoScoreDto);
    }

    private Money getPlayerMoney() {
        outputView.printInputAmount();
        Money money = new Money(inputView.getAmount());
        outputView.printLottoAmountMessage(money);
        return money;
    }

    private Lottos generateLottos(Money money) {
        Lottos lottos = new LottoCreator(pickNumbers).createLottos(money);
        outputView.printLottos(lottos);
        return lottos;
    }

    private WinningLotto getWinningLottery() {
        outputView.printInputLotteryMessage();
        final Lotto winLotto = new Lotto(inputView.getLotteryNumber());

        outputView.printInputBonusMessage();
        BonusNumber bonusNumber = new BonusNumber(inputView.getBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winLotto, bonusNumber);

        return winningLotto;
    }
}
