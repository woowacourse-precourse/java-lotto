package lotto;

public enum LottoEnum {
    LOTTO(1, 45, 6);

    private final int minNum;
    private final int maxNum;
    private final int Count;


    LottoEnum(int minNum, int maxNum ,int Count) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.Count = Count;
    }

    public int getMinNum() {
        return minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getCount() {
        return Count;
    }
}
