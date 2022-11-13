package lotto.model;

public enum Score {
    FIFTH(5000,"3개 일치 (5,000원) - "),
    FORTH(50000,"4개 일치 (50,000원) - "),
    THIRD(1500000,"5개 일치 (1,500,000원) - "),
    SECOND(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000,"6개 일치 (2,000,000,000원) - ");



    final private Integer money;
    final private String moneyStr;
    public Integer getMoney() {
        return money;
    }
    public String getMoneyStr() {
        return moneyStr;
    }
    private Score(Integer money,String moneyStr) {
        this.money = money;
        this.moneyStr = moneyStr;
    }
}
