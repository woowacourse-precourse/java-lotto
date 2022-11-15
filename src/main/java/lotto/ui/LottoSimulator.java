package lotto.ui;

import lotto.domain.*;
import lotto.message.PrintMessage;

import java.util.List;

public class LottoSimulator {

    private final LottoGenerator lottoGenerator;
    private final InputHandler inputHandler;
    private final Player player;

    public LottoSimulator() {
        player = new Player();
        lottoGenerator = new LottoGenerator();
        inputHandler = new InputHandler();
    }

    public void start() {
        System.out.println(PrintMessage.MESSAGE_ENTER_PRICE.getMessage());
        inputMoney();

        int count = buyLotto();
        System.out.printf(PrintMessage.MESSAGE_BUY_LOTTO.getMessage(), count);
        showLotteries();

        System.out.println(PrintMessage.MESSAGE_ENTER_WINNING_NUMBER.getMessage());
        Lotto winningLotto = inputWinningNumber();

        System.out.println(PrintMessage.MESSAGE_ENTER_BONUS_NUMBER.getMessage());
        int bonusNumber = inputLottoBonusNumber(winningLotto);

        List<LottoReward> lottoRewards = calculate(winningLotto, bonusNumber);
        showStatistics(lottoRewards);
    }

    private void inputMoney() {
        int money = inputHandler.inputMoney();
        player.setMoney(money);
    }

    private int buyLotto() {
        int money = player.getMoney();
        List<Lotto> lotteries = lottoGenerator.generateLotto(money);
        player.setLottos(lotteries);

        return lotteries.size();
    }

    private void showLotteries() {
        List<Lotto> lotteries = player.getLottos();
        lotteries.forEach(System.out::println);
    }

    private Lotto inputWinningNumber() {
        List<Integer> numbers = inputHandler.inputLottoNumber();
        return lottoGenerator.generateWinningLotto(numbers);
    }

    private int inputLottoBonusNumber(Lotto winningLotto) {
        return inputHandler.inputLottoBonusNumber(winningLotto);
    }

    private List<LottoReward> calculate(Lotto winningLotto, int bonusNumber) {
        LottoChecker lottoChecker = new LottoChecker(winningLotto, bonusNumber);
        return lottoChecker.calculate(player.getLottos());
    }

    private void showStatistics(List<LottoReward> lottoRewards) {
        OutputHandler outputHandler = new OutputHandler(lottoRewards, player);
        outputHandler.showStatistics();
    }
}
