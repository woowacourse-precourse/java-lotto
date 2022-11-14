package lotto.domain.enummodel;

public enum LottoEnum {
    LOTTO(1, 45, 6);

    private final int minNum;
    private final int maxNum;
    private final int Size;


    LottoEnum(int minNum, int maxNum ,int Size) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.Size = Size;
    }

    public int getMinNum() {
        return minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getSize() {
        return Size;
    }
}
