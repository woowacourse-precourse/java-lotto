package lotto.constant;

public enum WinningRule {
    RANK_1("1등", 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    RANK_2("2등", 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_3("3등", 1_500_000, "5개 일치 (1,500,000원)"),
    RANK_4("4등", 50_000, "4개 일치 (50,000원)"),
    RANK_5("5등", 5_000, "3개 일치 (5,000원)"),
    RANK_NONE("꽝", 0, "3개 미만 일치 (0원)")
    ;

    private final String rank;
    private final int money;
    private final String rule;

    WinningRule(String rank, int money, String rule) {
        this.rank = rank;
        this.money = money;
        this.rule = rule;
    }

    public String getRank() {
        return rank;
    }

    public int getMoney() {
        return money;
    }

    public String getRule() {
        return rule;
    }
}
