package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    private User user;
    private LotteryResult lotteryResult;
    private int lottoCount;
    private List<Lotto> userLotto = new ArrayList<>();

    public LottoProgram() {
        this.user = new User();
        this.lotteryResult = new LotteryResult();
    }

    public void start() {
        lottoCount = user.inputPrice();
        Message.printPurchaseAmount(lottoCount);
        generateLotto();
        inputLottoNumbers();
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
//        printStats();
        printEarningRate();
    }

    public void printStats(Ranking ranking) {
        //lotteryResult의 winningNumber랑 bonusNumber가지고 비교 연산해야함. 한줄씩.
        ranking = lotteryResult.calcResult(userLotto);
        System.out.println(ranking);
//        result += ranking.getHitCount() + "개";
    }

    public void printEarningRate() {

    }
}
