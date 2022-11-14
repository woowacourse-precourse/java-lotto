package lotto;

import lotto.domain.BonusNum;
import lotto.domain.LottoWallet;
import lotto.domain.WinningNum;
import lotto.service.*;
import lotto.view.EarningRateView;
import lotto.view.LottoView;
import lotto.view.ScorePrint;

import java.util.List;


public class Controller {
    WinningNum winningNum;
    LottoWallet wallet;
    BonusNum bonusNum;
    public void run() {

        setAllLotto(); // 도메인 로직

        printAllLotto();

        setWinningNum(); // 도메인 로직

        setBonusNum(); // 도메인 로직

        List<Integer> sameNumberCount = getSameNumberCount(); // 도메인 로직 (핵심)

        getScore(sameNumberCount); // 도메인 로직! (핵심)

        printScore();

        printEarningRate();
    }

    private void setAllLotto() {
        LottoWalletService walletService = new LottoWalletService();
        wallet = new LottoWallet(walletService.putLottoInWallet());
    }

    private void printAllLotto() {
        LottoView lottoView = new LottoView();

        lottoView.printAllLotto(wallet.getLottoWallet());
    }

    private void setWinningNum() {
        WinningNumService winningNumService = new WinningNumService();
        winningNum = new WinningNum(winningNumService.make());
    }

    private void setBonusNum() {
        BonusNumService bonusNumService = new BonusNumService();

        bonusNum = new BonusNum(bonusNumService.make(winningNum.getNumbers()));
    }

    private List<Integer> getSameNumberCount() {
        NumberMatcher numberMatcher = new NumberMatcher();
        return numberMatcher.matchedNums(wallet.getLottoWallet(), winningNum.getNumbers());
    }

    private void getScore(List<Integer> sameNumberCount){
        ScoreService scoreService = new ScoreService();
        scoreService.calculateScore(sameNumberCount);

        BonusScoreService bonusScoreService = new BonusScoreService();
        bonusScoreService.bonusCase(wallet.getLottoWallet(), winningNum.getNumbers(), bonusNum.getNumbers());
    }

    private void printScore() {
        ScorePrint scorePrint = new ScorePrint();
        scorePrint.printScoreBoard();
    }

    private static void printEarningRate() {
        EarningRateView earningRateView = new EarningRateView();
        earningRateView.print();
    }
}
