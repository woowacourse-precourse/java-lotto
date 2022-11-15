package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(new Winngins(2_000_000_000), 6),
    SECOND(new Winngins(30_000_000), 5),
    THIRD(new Winngins(1_500_000), 5),
    FORTH(new Winngins(50_000), 4),
    FIFTH(new Winngins(5_000), 3),
    LOSE(new Winngins(0), 0);

    private final Winngins winngins;
    private final int matchCount;


    Rank(Winngins winngins, int matchCount) {
        this.winngins = winngins;
        this.matchCount = matchCount;
    }

    public static Rank of(int matchCount, boolean bonusNumber) {
        if (matchCount == SECOND.matchCount && bonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(grade -> grade != SECOND)
                .filter(grade -> grade.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }

    public Winngins amount() {
        return winngins;
    }
}
