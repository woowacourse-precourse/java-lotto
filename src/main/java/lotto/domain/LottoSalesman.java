package lotto.domain;

public enum LottoSalesman {
    INSTANCE;
    public static final int MONEY_UNIT = 1000;

    public static int countPurchasedLotto(int money){
        return money / MONEY_UNIT;
    }

}
