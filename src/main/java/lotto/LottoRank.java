package lotto;

import java.text.DecimalFormat;

public enum LottoRank {
    FIFTH_PLACE(5000, 3, false),
    FOURTH_PLACE(50000, 4, false),
    THIRD_PLACE(1500000, 5, false),
    SECOND_PLACE(30000000, 5, true),
    FIRST_PLACE(2000000000, 6, false);

    private final static DecimalFormat formatter = new DecimalFormat("###,###");
    private final static String WIN_RESULT = "%d개 일치 (%s원) - %d개";
    private final static String SECOND_PLACE_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public final int price;
    public final int matchNumberCount;
    public final boolean hasBonusNumber;

    LottoRank(int price, int matchNumberCount, boolean hasBonusNumber) {
        this.price = price;
        this.matchNumberCount = matchNumberCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public boolean matchLottoRank(int matchNumberCount, boolean hasBonusNumber) {
        return this.matchNumberCount == matchNumberCount && this.hasBonusNumber == hasBonusNumber;
    }

    public String getResult(int rankCount) {
        String result = WIN_RESULT;
        if (this == SECOND_PLACE) {
            result = SECOND_PLACE_RESULT;
        }

        return String.format(result, matchNumberCount, formatter.format(price), rankCount);
    }
}
