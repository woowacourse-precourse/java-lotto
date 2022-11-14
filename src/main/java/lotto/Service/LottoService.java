package lotto.Service;

import lotto.Domain.LotteryTickets;
import lotto.Domain.LottoResult;
import lotto.Domain.Validator;
import lotto.Domain.WinningNumber;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoService {

    public static final int LOTTO_PRICE = 1000;

    public int getPurchaseAmount() {
        return getValidatePurchaseAmout();
    }

    public int getValidatePurchaseAmout() {
        int money = InputView.inputPurchaseAmount();
        return Validator.checkIsValidateAmount(money);
    }

    public LotteryTickets buyLottery(int purchaseAmount) {
        return new LotteryTickets(getLotteryPurchaseNum(purchaseAmount));
    }

    private int getLotteryPurchaseNum(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void showLottoPurchaseHistory(LotteryTickets lotteryTickets) {
        OutputView.showPurchasedLottos(lotteryTickets);
    }

    public WinningNumber getWinningNumsWithBonus() {
        List<Integer> winningLottoNums = getWinningNums();
        int bonusLottoNum = getBonusNum(winningLottoNums);

        return createWinningNums(winningLottoNums, bonusLottoNum);
    }

    public List<Integer> getWinningNums() {
        List<Integer> winningNums = InputView.getWinningNums();
        Validator.checkIsValidWinningNums(winningNums);
        return winningNums;
    }

    public int getBonusNum(List<Integer> winningNums) {
        int bonusNum = InputView.getBonusNum();
        Validator.checkIsValidBonusNum(winningNums, bonusNum);
        return bonusNum;
    }

    private WinningNumber createWinningNums(List<Integer> winningNums, int bonusLottoNum) {
        WinningNumber winningNumber = new WinningNumber(winningNums);
        winningNumber.setBonusNum(bonusLottoNum);
        return winningNumber;
    }

    public LottoResult getLottoResult(LotteryTickets lotteryTickets, WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoRanks(lotteryTickets, winningNumber);
        return lottoResult;
    }

    public void showLottoResult(LottoResult lottoResult) {
        OutputView.showLottoResult(lottoResult);
    }

    public void showEarningRatio(LottoResult lottoResult, int purchaseAmount) {
        OutputView.showEarningRatioResult(lottoResult.calcEarnedRatio(purchaseAmount) *100);
    }
}
