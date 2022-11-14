package lotto.LottoShop;

public class LottoShop {
    private final MoneyValidator moneyValidator;
    private final LottoPublishingMachine lottoProvidingMachine;
    private final Clerk clerk;

    private LottoShop() {
        this.moneyValidator = new MoneyValidator();
        this.lottoProvidingMachine = new LottoPublishingMachine();
        this.clerk = new Clerk(moneyValidator, lottoProvidingMachine);
    }

    private static class SingletonHelper{
        private static final LottoShop INSTANCE = new LottoShop();
    }

    public static LottoShop getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public Consumer takeOneConsumer() {
        Consumer consumer = new Consumer(clerk);
        consumer.purchaseLotto();
        return consumer;
    }
}
