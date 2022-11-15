package lotto;

import lotto.domain.*;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

import java.util.List;

public class LottoSimulator {

    private LottoChecker lottoChecker;
    private LottoGenerator lottoGenerator;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private Player player;

    public LottoSimulator() {
        player = new Player();
        lottoGenerator = new LottoGenerator();
        inputHandler = new InputHandler();
    }

    public void start(){
        System.out.println("금액을 입력해 주세요.");
        inputMoney();

        int count = buyLotto();
        System.out.printf("%d개를 구매했습니다.\n", count);
        showLotteries();

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = inputWinningNumber();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputLottoBonusNumber(winningLotto);

        List<LottoReward> lottoRewards = calculate(winningLotto, bonusNumber);
        showStatistics(lottoRewards);
    }

    // 돈 입력
    private void inputMoney(){
        int money = inputHandler.inputMoney();
        player.setMoney(money);
    }

    // 로또 구매
    private int buyLotto() {
        int money = player.getMoney();
        List<Lotto> lotteries = lottoGenerator.generateLotto(money);
        player.setLottos(lotteries);

        return lotteries.size();
    }

    // 구매한 로또 출력
    private void showLotteries() {
        List<Lotto> lotteries = player.getLottos();
        lotteries.forEach(System.out::println);
    }

    // 당첨 번호 입력
    private Lotto inputWinningNumber() {
        List<Integer> numbers = inputHandler.inputLottoNumber();
        return lottoGenerator.generateWinningLotto(numbers);
    }

    // 보너스 번호 입력
    private int inputLottoBonusNumber(Lotto winningLotto) {
        return inputHandler.inputLottoBonusNumber(winningLotto);
    }

    // 당첨 로또 분석 및 반환
    private List<LottoReward> calculate(Lotto winningLotto, int bonusNumber) {
        lottoChecker = new LottoChecker(winningLotto, bonusNumber);
        return lottoChecker.calculate(player.getLottos());
    }

    // 통계 출력
    private void showStatistics(List<LottoReward> lottoRewards) {
        outputHandler = new OutputHandler(lottoRewards, player);
        outputHandler.showStatistics();
    }
}
