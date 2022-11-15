package lotto.enumeration;

import java.util.Arrays;

public enum LottoRankInformation {
    OTHERS(0, false, 0L),
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L);

    private final int matchNumber;
    private final boolean matchBonus;
    private final long prizeMoney;

    LottoRankInformation(int matchNumber, boolean matchBonus, long prizeMoney) {
        this.matchNumber = matchNumber;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public long getWinnings(int count) {
        return this.prizeMoney * count;
    }

    public String getInformation(int count) {
        if (validateSecond()) {
            String RESULT_RANK_SECOND_ALERT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
            return String.format(RESULT_RANK_SECOND_ALERT, count);
        }
        String RESULT_RANK_ALERT = "%d개 일치 (%,d원) - %d개";
        return String.format(RESULT_RANK_ALERT, this.matchNumber, this.prizeMoney, count);
    }

    private boolean validateSecond() {
        return this.matchNumber == 5 && this.matchBonus;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public static LottoRankInformation makeLottoRankInformation(int matchNumber, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(LottoRankInformation -> LottoRankInformation.validateMatchNumber(matchNumber) && LottoRankInformation.validateMatchBonus(matchBonus))
                .findFirst()
                .orElse(LottoRankInformation.OTHERS);
    }

    private boolean validateMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }

    private boolean validateMatchNumber(int matchNumber) {
        return this.matchNumber == matchNumber;
    }

}
