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

        setAllLotto();

        printAllLotto();

        setWinningNum();

        setBonusNum();

        List<Integer> sameNumberCount = getSameNumberCount();

        printScore(sameNumberCount);

        printEarningRate();
    }

    private void setBonusNum() {
        BonusNumMaker bonusNumMaker = new BonusNumMaker();

        bonusNum = new BonusNum(bonusNumMaker.make(winningNum.getNumbers()));
    }

    private void setWinningNum() {
        WinningNumMaker winningNumMaker = new WinningNumMaker();
        winningNum = new WinningNum(winningNumMaker.make());
    }

    private void setAllLotto() {
        LottoWalletService walletMaker = new LottoWalletService();
        wallet = new LottoWallet(walletMaker.putLottoInWallet());
    }

    private void printAllLotto() {
        LottoView lottoView = new LottoView();

        lottoView.printAllLotto(wallet.getLottoWallet());
    }

    private List<Integer> getSameNumberCount() {
        NumberMatcher numberMatcher = new NumberMatcher();
        return numberMatcher.matchedNums(wallet.getLottoWallet(), winningNum.getNumbers());
    }

    private void printScore(List<Integer> sameNumberCount) {
        ScoreService scoreService = new ScoreService();
        scoreService.calculateScore(sameNumberCount);

        BonusScoreService bonusScoreService = new BonusScoreService();
        bonusScoreService.bonusCase(wallet.getLottoWallet(), winningNum.getNumbers(), bonusNum.getNumbers());

        ScorePrint scorePrint = new ScorePrint();
        scorePrint.printScoreBoard();
    }

    private static void printEarningRate() {
        EarningRateView earningRateView = new EarningRateView();
        earningRateView.print();
    }
}
