package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    private User user;
    private LotteryResult lotteryResult;
    private int lottoCount;
    private List<Lotto> userLotto = new ArrayList<>();
    private UserInterface userInterface;
    private WinningResult winningResult;
    private WinningNumber winningNumber;

    public LottoProgram() {
        this.user = new User();
        this.lotteryResult = new LotteryResult();
        this.userInterface = new UserInterface();
        this.winningNumber = new WinningNumber();
    }

    public void start() {
        lottoCount = user.inputPrice();
        Message.printPurchaseAmount(lottoCount);
        generateLotto();
//        inputLottoNumbers();
        enterWinningNumber();
        printResult();
    }

    public void generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        userLotto = lottoGenerator.publishLotto();
        lottoGenerator.printLotto();
    }

    public void inputLottoNumbers() {
        lotteryResult.winningNumbers = user.inputWinningNumbers();
        lotteryResult.bonusNumber = user.inputBonusNumbers();
    }

    public void printResult() {
        Message.printResult();
        winningResult = new WinningResult(winningNumber);
        userInterface.printWinningHistory(winningResult.winningHistory(userLotto));
        userInterface.printWinningRate(winningResult.winningRate(user.price));
//        printStats();
//        printEarningRate();
    }

    public void printStats(Rank rank) {
        //lotteryResult의 winningNumber랑 bonusNumber가지고 비교 연산해야함. 한줄씩.
        rank = lotteryResult.calcResult(userLotto);
        System.out.println(rank);
//        result += ranking.getHitCount() + "개";
    }

    public void printEarningRate() {

    }

    private void enterWinningNumber() {
        winningNumber.getWinningNumber();
    }
}
