package lotto.message;

public enum NumberType {

    ONE(1),
    SIX(6),

    FORTY_FIVE(45);
    ;

    private final int numberType;

    NumberType(int numberType) {
        this.numberType = numberType;
    }

    public int getNumberType() {
        return numberType;
    }
}
