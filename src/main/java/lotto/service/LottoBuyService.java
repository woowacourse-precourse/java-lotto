package lotto.service;

import lotto.domain.LottoPurchaseInfo;
import lotto.message.PrintController;

public class LottoBuyService {

    private LottoPurchaseInfo lottoPurchaseInfo;
    private LottoPrizeRecordingService lottoPrizeRecordingService;
    private LottoSellService lottoSellService;
    private PrintController printController;

    public LottoBuyService() {
        lottoSellService = new LottoSellService();
        lottoPrizeRecordingService = new LottoPrizeRecordingService();
        printController = new PrintController();
    }

    public void buyLotto() {
        lottoPurchaseInfo = lottoSellService.sellLotto();
        printController.print(lottoPurchaseInfo.getLottoNumbers());
    }

    public void inputNumber() {
        lottoSellService.inputNumber();
    }

    public void checkWinStatics() {
        lottoPurchaseInfo.getLottoNumbers()
                .forEach(
                        (lotto) -> lottoPrizeRecordingService.setPrizeRecording(lottoSellService.checkMatchCount(lotto))
                );

        printController.print(lottoPrizeRecordingService.getPrizeRecording());
    }

    public void checkRate() {
        double prizeRate = lottoPrizeRecordingService.getPrizeRate(lottoPurchaseInfo.getPurchaseMoney());

        printController.print(prizeRate);
    }

}
