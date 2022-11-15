package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.ui.InputHandler;
import lotto.domain.Player;

import java.util.List;

public class LottoSimulator {

    private LottoChecker lottoChecker;
    private LottoGenerator lottoGenerator;
    private InputHandler inputHandler;
//    private OutputHandler outputHandler;
    private Player player;

    public LottoSimulator() {
        player = new Player();
        lottoGenerator = new LottoGenerator();
        lottoChecker = new LottoChecker();
        inputHandler = new InputHandler();
//        outputHandler = new OutputHandler();
    }

    public void start(){
        System.out.println("금액을 입력해 주세요.");
        inputMoney();

        int count = buyLotto();
        System.out.printf("%d개를 구매했습니다.\n", count);
        showLotteries();

        System.out.println("당첨 번호를 입력해 주세요.");
        inputLottoNumber();

        System.out.println("보너스 번호를 입력해 주세요.");
        inputLottoBonusNumber();

        calculate();
        showStatistics();
    }

    private void calculate() {
        lottoChecker.calculate(player);
    }

    private int buyLotto() {
        int money = player.getMoney();
        List<Lotto> lotteries = lottoGenerator.generateLotto(money);
        player.setLotteries(lotteries);

        return lotteries.size();
    }

    private void inputMoney(){
        int money = inputHandler.inputMoney();
        player.setMoney(money);
    }

    private void showLotteries() {
        List<Lotto> lotteries = player.getLotteries();
        lotteries.forEach(System.out::println);
    }

    private void inputLottoNumber() {
        Lotto winLotto = lottoGenerator.generateWinLotto(inputHandler);
        lottoChecker.setWinningLotto(winLotto);
    }

    private void inputLottoBonusNumber() {
        int bonusNumber = inputHandler.inputLottoBonusNumber();
        lottoChecker.setBonusNumber(bonusNumber);
    }

    // TODO
    private void showStatistics() {
//        outputHandler.showStatistics();
    }
}
