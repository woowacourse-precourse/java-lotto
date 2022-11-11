package lotto.lottoShop;

public class LottoShop {
    private final MoneyValidator moneyValidator;
    private final LottoProvidingMachine lottoProvidingMachine;
    private final Clerk clerk;

    private LottoShop() {
        this.moneyValidator = new MoneyValidator();
        this.lottoProvidingMachine = new LottoProvidingMachine();
        this.clerk = new Clerk(moneyValidator, lottoProvidingMachine);
    }

    private static class SingletonHelper{
        private static final LottoShop INSTANCE = new LottoShop();
    }

    public static LottoShop getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void takeOneConsumer() {
        Consumer consumer = new Consumer(clerk);
        consumer.purchaseLotto();
    }
}
