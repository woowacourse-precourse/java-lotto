package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final PickNumbers pickNumbers;

    public LottoMachine(InputView inputView, OutputView outputView, PickNumbers pickNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pickNumbers = pickNumbers;
    }

    public void run() {
        Money money = getPlayerMoney();

        Lottos lottos = generateLottos(money);

        WinningLottery winningLottery = getWinningLottery();

        LottoStatistic lottoStatistic = new LottoStatistic(winningLottery, lottos);
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

    private WinningLottery getWinningLottery() {
        outputView.printInputLotteryMessage();
        WinningLottery winningLottery = new WinningLottery(new Lotto(inputView.getLotteryNumber()));

        outputView.printInputBonusMessage();
        BonusNumber bonusNumber = new BonusNumber(inputView.getBonusNumber());
        winningLottery.setBonusNumber(bonusNumber);

        return winningLottery;
    }
}
