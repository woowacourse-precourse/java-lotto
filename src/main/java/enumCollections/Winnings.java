package enumCollections;

public enum Winnings {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5000);

    private final int amount;

    Winnings(int amount) {
        this.amount = amount;
    }

    public static int getAmount(String rank) {
        return Winnings.valueOf(rank).amount;
    }
}
