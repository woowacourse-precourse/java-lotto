package lotto;

public class LottoRunner {
    private static LottoRunner lottoRunner;

    private final UserInputGetter userInputGetter;
    private final PurchaseResultDemonstrator purchaseResultDemonstrator;
    private final PurchaseResultProcessor purchaseResultProcessor;

    private LottoRunner() {
        this.userInputGetter = new UserInputGetter();
        this.purchaseResultDemonstrator = new PurchaseResultDemonstrator();
        this.purchaseResultProcessor = new PurchaseResultProcessor();
    }

    public static LottoRunner getLottoRunner() {
        if (lottoRunner == null) {
            lottoRunner = new LottoRunner();
        }
        return lottoRunner;
    }

    public void run() {
        int totalPrice = this.userInputGetter.getTotalPriceFromUser();
        System.out.println();

        PurchaseResult purchaseResult = this.purchaseResultProcessor.getPurchaseResult(totalPrice);
        this.purchaseResultDemonstrator.printPurchaseResult(purchaseResult);
        System.out.println();
    }


}
