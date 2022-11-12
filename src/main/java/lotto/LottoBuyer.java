package lotto;

public class LottoBuyer {

    private LottoPurchaseInfo lottoPurchaseInfo;
    private LottoPrizeRecordingManager lottoPrizeRecordingManager;
    private LottoSeller lottoSeller;
    private PrintController printController;

    public LottoBuyer() {
        lottoSeller = new LottoSeller();
        lottoPrizeRecordingManager = new LottoPrizeRecordingManager();
        printController = new PrintController();
    }

    public void buyLotto() {
        lottoPurchaseInfo = lottoSeller.sellLotto();
        printController.print(lottoPurchaseInfo.getLottoNumbers());
    }

    public void checkWinStatics() {

        lottoPurchaseInfo.getLottoNumbers()
                .forEach(
                        (lotto) -> lottoPrizeRecordingManager.setPrizeRecording(lottoSeller.checkMatchCount(lotto))
                );

        printController.print(lottoPrizeRecordingManager.getPrizeRecording());

    }

    public void checkRate() {
        lottoPrizeRecordingManager.getPrizeRate(lottoPurchaseInfo.getPurchaseMoney());
    }

}
