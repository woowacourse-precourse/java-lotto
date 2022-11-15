package lotto.utils;

import lotto.domain.Ranking;

public final class Constants {
    public static final int LOTTO_PRICE = 1_000;
    public static final int COUNT_OF_NUMBERS_IN_LOTTO = 6;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public static final int LAST_PLACE = Ranking.values().length - 1;
    public static final int FIRST_PLACE = 1;
    public static final int MINIMUN_REQUIRED_NUMBER_OF_MATCHING_NUMBER = Ranking.FIFTH.getMatchingNumberCount();
}
