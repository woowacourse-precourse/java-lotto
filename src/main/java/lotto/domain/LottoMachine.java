package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomUniqueNumbers randomUniqueNumbers;

    public LottoMachine(InputView inputView, OutputView outputView, RandomUniqueNumbers randomUniqueNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomUniqueNumbers = randomUniqueNumbers;
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
        Lottos lottos = new LottoCreator(randomUniqueNumbers).createLottos(money);
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
