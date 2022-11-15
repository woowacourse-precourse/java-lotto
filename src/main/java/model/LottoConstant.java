package model;

public enum LottoConstant {
    MAX_LOTTO_NUMBER(45),
    MIN_LOTTO_NUMBER(1),
    LOTTO_NUMBER_COUNT(6),
    STANDARD_MONEY(1000);

    private final int number;

    LottoConstant(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
