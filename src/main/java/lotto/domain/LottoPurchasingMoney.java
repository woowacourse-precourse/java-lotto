package lotto.domain;

public class LottoPurchasingMoney {

    private final int lottoMoney;

    private final String MONEY_INPUT_ERROR = "[ERROR] 로또를 구매하시려면 천원 단위의 금액만 가능합니다.";

    public LottoPurchasingMoney(int lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public void validateMoneyInput(int lottoMoney) {
        if(lottoMoney % 1000 == 0) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR);
        }
    }
}
