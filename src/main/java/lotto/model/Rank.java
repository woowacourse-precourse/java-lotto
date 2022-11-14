package lotto.model;

public enum Rank {
    first("6개 일치 (2,000,000,000원) - ",2000000000),
    second("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    third("5개 일치 (1,500,000원)", 1500000),
    fourth("4개 일치 (50,000원)", 50000),
    fifth("3개 일치 (5000원)", 5000);

    final private String matchMessage;
    final private Integer matchMoney;

    public Integer getMatchMoney() {
        return matchMoney;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    private Rank(String matchMessage, Integer matchMoney) {
        this.matchMessage = matchMessage;
        this.matchMoney = matchMoney;
    }
}
