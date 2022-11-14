package lotto.model;

public enum Rank {

    fifth("3개 일치 (5,000원) - ", 5000),
    fourth("4개 일치 (50,000원) - ", 50000),
    third("5개 일치 (1,500,000원) - ", 1500000),
    second("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    first("6개 일치 (2,000,000,000원) - ",2000000000);

    final private String matchMessage;
    final private Integer matchMoney;

    public Integer getMatchMoney() {
        return matchMoney;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    Rank(String matchMessage, Integer matchMoney) {
        this.matchMessage = matchMessage;
        this.matchMoney = matchMoney;
    }
}
