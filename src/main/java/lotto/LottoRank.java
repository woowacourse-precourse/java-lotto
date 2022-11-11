package lotto;

public enum LottoRank {
    First(0),Second(1),Third(2),Fourth(3),Fifth(4),Sixth(5);
    private int value;
    LottoRank(int i) {
        this.value = i;
    }
    public int getValue(){ return this.value; }
}
