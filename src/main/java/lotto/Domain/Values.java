package lotto.Domain;

public enum Values {
    LOTTO_NUM(6);

    private final int value;

    Values(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
