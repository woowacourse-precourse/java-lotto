package lotto.util;

public enum Type {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - %d개%n"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    THIRD(1_500_000, "5개 일치 (1,500,000원) - %d개%n"),
    FOURTH(50_000, "4개 일치 (50,000원) - %d개%n"),
    FIFTH(5_000, "3개 일치 (5,000원) - %d개%n");

    private final double prize;
    private final String comment;

    Type(double prize, String comment) {
        this.prize = prize;
        this.comment = comment;
    }

    public double getPrize() {
        return prize;
    }

    public String getComment() {
        return comment;
    }
}
