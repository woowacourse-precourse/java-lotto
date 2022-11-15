package lotto;

public enum GameData {
    FIFTH("3개 일치 (5,000원) - ", 5000L, 0),
    FOURTH("4개 일치 (50,000원) - ", 50000L, 0),
    THIRD("5개 일치 (1,500,000원) - ", 1500000L, 0),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000L, 0),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000L, 0);

    String printWord;
    Long prizeMoney;
    Integer count;

    GameData(String printWord, Long prizeMoney, Integer count) {
        this.printWord = printWord;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

    public String getPrintWord() {
        return this.printWord;
    }

    public Integer getCount() {
        return this.count;
    }

    public Long getIncome() {
        return this.prizeMoney * this.count;
    }


}
