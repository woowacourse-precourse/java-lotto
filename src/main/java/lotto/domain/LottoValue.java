package lotto.domain;

public enum LottoValue {

    START_LOTTO_NUMBER(1),
    END_LOTTO_NUMBER(45),
    LOTTO_LENGTH(6),
    ONE_LOTTO_PRICE(1000);
    private final int value;

    LottoValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
