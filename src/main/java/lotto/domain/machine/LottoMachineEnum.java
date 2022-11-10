package lotto.domain.machine;

public enum LottoMachineEnum {
    LOTTO_PRICE(1000);
    
    private final Integer value;
    
    LottoMachineEnum(Integer value) {
        this.value = value;
    }
    
    public Integer getValue() {
        return this.value;
    }
}
