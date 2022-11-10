package lotto.domain.number;

public enum LottoNumberEnum {
    START_NUMBER(1), END_NUMBER(45), NUMBER_COUNT(6);
    
    private final Integer value;
    
    LottoNumberEnum(Integer value) {
        this.value = value;
    }
    
    public Integer getValue() {
        return this.value;
    }
}
