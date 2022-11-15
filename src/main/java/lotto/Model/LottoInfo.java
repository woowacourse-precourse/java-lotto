package lotto.Model;

public enum LottoInfo {
    LOTTO_SIZE(6),
    LOTTO_START_RANGE(1),
    LOTTO_END_RANGE(45),
    PRICE_PER_LOTTO_TICKET(1000);

    private final int number;
    LottoInfo(int number) {
        this.number = number;
    }

    public Integer getNumber(){
        return number;
    }
}
