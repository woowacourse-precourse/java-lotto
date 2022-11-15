package constants;

import java.util.regex.Pattern;

public abstract class LottoConstants {

    public static final Pattern REGEX = Pattern.compile("[0-9]+");
    public static final int MIN_LOTTO_VALUE = 1;
    public static final int MAX_LOTTO_VALUE = 45;
    public static final int BONUS_MATCH_LOTTO_NUM = 5;
    public static final int LOTTO_NUM = 6;
    public static final int MONEY_UNIT = 1000;
    public static final String SEPARATOR = ",";
    public static final int PERCENTAGE_UNIT = 100;

    private LottoConstants() {}
}
