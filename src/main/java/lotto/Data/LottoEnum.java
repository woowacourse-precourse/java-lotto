package lotto.Data;

public enum LottoEnum {
    FIFTH(5000),FOURTH(50000),THIRD(1500000),SECOND(30000000),FIRST(2000000000);
    private final int number;
    LottoEnum(int number) {
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}
