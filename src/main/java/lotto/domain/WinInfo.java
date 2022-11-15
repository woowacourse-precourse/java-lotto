package lotto.domain;

public enum WinInfo {
    NONE(0, ""),
    FIFTH(5000, "3개 일치 (%,d원) - %d개"),
    FOURTH(50000, "4개 일치 (%,d원) - %d개"),
    THIRD(1500000, "5개 일치 (%,d원) - %d개"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    FIRST(2000000000, "6개 일치 (%,d원) - %d개");

    private final int reward;
    private final String format;

    WinInfo(int reward, String format) {
        this.reward = reward;
        this.format = format;
    }

    public static WinInfo convert(int count, boolean bonus) {
        if (count == 6) {
            return FIRST;
        }

        if (count == 5 && bonus) {
            return SECOND;
        }

        if (count == 5) {
            return THIRD;
        }

        if (count == 4) {
            return FOURTH;
        }

        if (count == 3) {
            return FIFTH;
        }

        return NONE;
    }

    public int getReward() {
        return reward;
    }

    public String getFormat() {
        return format;
    }
}
