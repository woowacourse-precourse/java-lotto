package lotto.domain.lotto.lottocompany;

public enum Win {
    first("6개 일치", 6,
            2_000_000_000, "2,000,000,000원"),
    second("5개 일치, 보너스 볼 일치", 5,
            30_000_000, "30,000,000원"),
    third("5개 일치", 5,
            1_500_000, "1,500,000원"),
    fourth("4개 일치", 4,
            50_000, "50,000원"),
    fifth("3개 일치", 3,
            5_000, "5,000원");

    private final String prizeInformation;
    private final int winCondition;
    private final int prizeMoney;
    private final String prizeMoneyTag;

    Win(String prizeInformation, int winCondition, int prizeMoney, String prizeMoneyTag) {
        this.prizeInformation = prizeInformation;
        this.winCondition = winCondition;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyTag = prizeMoneyTag;
    }

    public String getPrizeInformation() {
        return prizeInformation;
    }

    public int getWinCondition() {
        return winCondition;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMoneyTag() {
        return prizeMoneyTag;
    }
}
