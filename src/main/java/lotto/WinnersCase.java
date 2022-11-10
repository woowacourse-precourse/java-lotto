package lotto;

public enum WinnersCase {
    FIFTH("3개 일치 (5,000원) - ", 5000L, 3.0, 0),
    FOURTH("4개 일치 (50,000원) - ", 50000L, 4.0, 0),
    THIRD("5개 일치 (1,500,000원) - ", 1500000L, 5.0, 0),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000L, 5.5, 0),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000L, 6.0, 0);

    private String ranking;
    private Long prizeMoney;
    private Double matchingNumber;
    private Integer count;

    WinnersCase(String ranking, Long prizeMoney, Double matchingNumber, Integer count) {
        this.ranking = ranking;
        this.prizeMoney = prizeMoney;
        this.matchingNumber = matchingNumber;
        this.count = count;
    }

    public String getRanking() {
        return ranking;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public Double getMatchingNumber() {
        return matchingNumber;
    }

    public Integer getCount() {
        return count;
    }

    public void addCount() {
        this.count += 1;
    }

    public void totalPrizeMoney(Long prizeMoney, Integer count) {
        this.prizeMoney = prizeMoney * count;
    }
}