package lotto;

public enum LottoStats {
    FIFTH(0,"3개 일치 (5,000원) - %d개%n", 5_000),
    FOURTH(1,"4개 일치 (50,000원) - %d개%n", 50_000),
    THIRD(2,"5개 일치 (1,500,000원) - %d개%n", 1_500_000),
    SECOND(3,"5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", 30_000_000),
    FIRST(4,"6개 일치 (2,000,000,000원) - %d개%n", 2_000_000_000);

    private final int index;
    private final String message;
    private final long prize;

    LottoStats(int index, String message, long prize) {
        this.index = index;
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return message;
    }

    public long getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }



}
