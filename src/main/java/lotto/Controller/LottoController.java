package lotto.Controller;

import lotto.Domain.LotteryTickets;
import lotto.Domain.LottoResult;
import lotto.Domain.WinningNumber;
import lotto.Service.LottoService;

public class LottoController {

    public LottoService lottoService = new LottoService();

    public void startLotto() {

        try {
            int purchaseAmount = lottoService.getPurchaseAmount();
            LotteryTickets lotteryTickets = lottoService.buyLottery(purchaseAmount);
            lottoService.showLottoPurchaseHistory(lotteryTickets);

            WinningNumber winningNumbers = lottoService.getWinningNumsWithBonus();

            LottoResult lottoResult = lottoService.getLottoResult(lotteryTickets, winningNumbers);
            lottoService.showLottoResult(lottoResult);
            lottoService.showEarningRatio(lottoResult, purchaseAmount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
