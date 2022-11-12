package lotto.domain.lotto.lottocompany;

public enum Win {
    first("6개 번호 일치", 6, "2,000,000,000원"),
    second("5개 번호 + 보너스 번호 일치", 5, "30,000,000원"),
    third("5개 번호 일치", 5, "1,500,000원"),
    fourth("4개 번호 일치", 4, "50,000원"),
    fifth("3개 번호 일치", 3, "5,000원");

    private final String prizeInformation;
    private final int winCondition;
    private final String prizeMoney;

    Win(String prizeInformation, int winCondition, String prizeMoney) {
        this.prizeInformation = prizeInformation;
        this.winCondition = winCondition;
        this.prizeMoney = prizeMoney;
    }

    public String getPrizeInformation() {
        return prizeInformation;
    }

    public int getWinCondition() {
        return winCondition;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
}
