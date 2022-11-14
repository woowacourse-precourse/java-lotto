package lotto.Controller;

import lotto.Domain.LotteryTickets;
import lotto.Domain.WinningNumber;
import lotto.Service.LottoService;

public class LottoController {

    public LottoService lottoService = new LottoService();

    public void startLotto() {

        try {
            int purchase = lottoService.getPurchaseAmount();
            LotteryTickets lotteryTickets = lottoService.buyLottery(purchase);
            lottoService.showLottoPurchaseHistory(lotteryTickets);

            WinningNumber winningNumbers = lottoService.getWinningNumsWithBonus();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
