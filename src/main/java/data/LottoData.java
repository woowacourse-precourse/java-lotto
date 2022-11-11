package data;

public enum LottoData {
    FIRST(6,false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private int winningAmount;
    private boolean isHavingBonus;
    private int prize;

    LottoData(int winningAmount, boolean isHavingBonus, int prize){
        this.winningAmount = winningAmount;
        this.isHavingBonus = isHavingBonus;
        this.prize = prize;
    }
}
