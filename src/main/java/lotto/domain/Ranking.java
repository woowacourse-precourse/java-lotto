package lotto.domain;

public enum Ranking {
    fifth(5, 3, 5_000, "3개 일치 (5,000원) - %d개\n"),
    fourth(4, 4, 50_000, "4개 일치 (50,000원) - %d개\n"),
    third(3, 5, 1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    second(2, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    first(1, 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n");

    private final int value;
    private final int matchingCount;
    private final int prizeMoney;
    private final String printFormat;

    Ranking(int value, int numberOfMatching, int prizeMoney, String printFormat) {
        this.value = value;
        this.matchingCount = numberOfMatching;
        this.prizeMoney = prizeMoney;
        this.printFormat = printFormat;
    }

    public int value() {
        return value;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public String printFormat() {
        return printFormat;
    }
}
