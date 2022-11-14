package lotto.domain;

public class LottoMoney {
    private static final int MIN_COST = 1000;
    private static final String NO_UNIT_AMOUNT_ERROR = "[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.";
    private static final String NO_POSITIVE_AMOUNT_ERROR = "[ERROR] 로또 구입 금액은 양수이여야 합니다.";
    private final int money;

    public LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int calculateLottoTicket(){
        return money / MIN_COST;
    }

    private void validate(int money){
        if (money % MIN_COST != 0){
            throw new IllegalArgumentException(NO_UNIT_AMOUNT_ERROR);
        }

        if (money <= 0){
            throw new IllegalArgumentException(NO_POSITIVE_AMOUNT_ERROR);
        }
    }
}
