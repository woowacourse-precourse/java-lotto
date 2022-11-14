package lotto;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public LottoService() {
    }

    public void init(){
        long lottoQuantity = purchaseLotto();
    }

    private long purchaseLotto(){
        Long purchaseMoney = UserInput.getPurchaseMoney();
        return purchaseMoney / LOTTO_PRICE;
    }
}
