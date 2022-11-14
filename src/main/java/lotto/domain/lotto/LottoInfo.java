package lotto.domain.lotto;

public enum LottoInfo {
    MAX(45), MIN(1), LENGTH(6), PRICE(1000);
    private final int val;

    LottoInfo(int val) {
        this.val = val;
    }

    public int getValue(){
        return this.val;
    }

    @Override
    public String toString(){
        return String.valueOf(this.val);
    }
}
