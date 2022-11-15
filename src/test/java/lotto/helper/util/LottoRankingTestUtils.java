package lotto.helper.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import lotto.helper.exception.CannotReflectionException;
import lotto.mvc.util.LottoRanking;

public final class LottoRankingTestUtils {

    private static final String REWARD_FIELD_NAME = "lottoRankingReward";

    private LottoRankingTestUtils() {
    }

    public static BigDecimal findLottoGradeReward(LottoRanking lottoRanking) {
        Field reward = ReflectionFieldUtils.processReflectionField(LottoRanking.class, REWARD_FIELD_NAME);

        try {
            return (BigDecimal) reward.get(lottoRanking);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
