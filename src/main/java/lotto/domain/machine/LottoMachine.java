package lotto.domain.machine;

import lotto.domain.earning.Earning;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeStatistics;
import lotto.domain.purchase.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void run() {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            Purchase purchase = purchaseService(inputView);
            LottoGenerator lottos = lottoGeneratorService(outputView, purchase);
            Prize prize = prizeService(inputView);
            PrizeStatistics prizeStatistics = prizeStatisticsService(outputView, lottos, prize);
            earningService(outputView, purchase, prizeStatistics);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Purchase purchaseService(InputView inputView) {
        String inputPurchase = inputView.purchaseInput();
        return new Purchase(inputPurchase);
    }

    private LottoGenerator lottoGeneratorService(OutputView outputView, Purchase purchase) {
        LottoGenerator lottos = new LottoGenerator(purchase.numOfLotto(purchase.getAmount()));
        outputView.lottosOutput(lottos.getLottos());
        return lottos;
    }

    private Prize prizeService(InputView inputView) {
        String inputPrize = inputView.prizeInput();
        String inputBonus = inputView.bonusInput();
        return new Prize(inputPrize, inputBonus);
    }

    private PrizeStatistics prizeStatisticsService(OutputView outputView, LottoGenerator lottos, Prize prize) {
        PrizeStatistics prizeStatistics = new PrizeStatistics();
        prizeStatistics.calculateStatistics(lottos, prize);
        outputView.prizeStatisticsOutPut(prizeStatistics);
        return prizeStatistics;
    }

    private void earningService(OutputView outputView, Purchase purchase, PrizeStatistics prizeStatistics) {
        Earning earning = new Earning(purchase.getAmount(), prizeStatistics);
        outputView.earningOutput(earning);
    }
}
