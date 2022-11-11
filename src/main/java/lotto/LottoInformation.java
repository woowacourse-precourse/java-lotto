package lotto;

import java.util.Arrays;

public enum LottoInformation {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    OTHER(0, false, 0L);

    private final int matchNumber;
    private final boolean matchBonus;
    private final long prizeMoney;

    LottoInformation(int matchNumber, boolean matchBonus, long prizeMoney) {
        this.matchNumber = matchNumber;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static LottoInformation makeLottoInformation(int matchNumber, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoInformation -> lottoInformation.validateMatchNumber(matchNumber) && lottoInformation.validateMatchBonus(matchBonus))
                .findFirst()
                .orElse(LottoInformation.OTHER);
    }

    private boolean validateMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }

    private boolean validateMatchNumber(int matchNumber) {
        return this.matchNumber == matchNumber;
    }

}
