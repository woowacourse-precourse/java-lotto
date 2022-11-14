package data;

public enum LottoData {
    FIRST("FIRST",6, 2000000000),
    SECOND("SECOND",5, 30000000),
    THIRD("THIRD",5, 1500000),
    FOURTH("FOURTH",4, 50000),
    FIFTH("FIFTH",3, 5000);

    private String prizeName;
    private int prizeAmount;
    private int prizeMoney;
    LottoData(String prizeName, int prizeAmount, int prizeMoney) {
        this.prizeName = prizeName;
        this.prizeAmount = prizeAmount;
        this.prizeMoney = prizeMoney;
    }
}
