package constants;

public enum PrizeDivision {
    EMPTY("invalid","invalid"),
    FIRST("6개 일치","2,000,000,000"),
    SECOND("5개 일치, 보너스 볼 일치","30,000,000"),
    THIRD("5개 일치","1,500,000"),
    FOURTH("4개 일치","50,000"),
    FIFTH("3개 일치","5,000")
    ;

    private final String sameCount;
    private final String money;

    PrizeDivision(String sameCount, String money) {
        this.sameCount = sameCount;
        this.money = money;
    }

    public String getSameCount() {
        return sameCount;
    }

    public String getMoney() {
        return money;
    }
}
