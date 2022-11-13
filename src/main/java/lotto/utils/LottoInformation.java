package lotto.utils;

public class LottoInformation {
    public final static int LOTTO_PRICE = 1000;
    public final static int LOTTO_SELECTION_COUNT = 6;
    public final static int LOTTO_BONUS_NUMBER_COUNT = 1;
    public final static int LOTTO_START_NUMBER = 1;
    public final static int LOTTO_END_NUMBER = 45;
    public final static String LOTTO_PATTERN = "([1-9]|[1-3][0-9]|4[0-5])";
    public final static String SIX_LOTTO_PATTERN;

    static {
        SIX_LOTTO_PATTERN = String.join(
                ",",
                new String[]{LOTTO_PATTERN, LOTTO_PATTERN, LOTTO_PATTERN, LOTTO_PATTERN, LOTTO_PATTERN, LOTTO_PATTERN}
        );
    }
}