package lotto.helper.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;
import lotto.mvc.model.LottoResult;
import lotto.helper.exception.CannotReflectionException;
import lotto.mvc.util.LottoRanking;

public final class LottoResultTestUtils {

    private static final String RESULT_FIELD_NAME = "lottoRankingResult";
    private static final String REVENUE_PERCENT_FIELD_NAME = "revenuePercent";

    private LottoResultTestUtils() {
    }

    @SuppressWarnings("unchecked")
    public static Map<LottoRanking, Integer> findLottoRankingResult(LottoResult lottoResult) {
        Field lottoRankingResult = ReflectionFieldUtils.processReflectionField(LottoResult.class, RESULT_FIELD_NAME);

        try {
            return (Map<LottoRanking, Integer>) lottoRankingResult.get(lottoResult);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }

    public static BigDecimal findRevenuePercent(LottoResult lottoResult) {
        Field revenuePercentField = ReflectionFieldUtils
                .processReflectionField(LottoResult.class, REVENUE_PERCENT_FIELD_NAME);

        try {
            return (BigDecimal) revenuePercentField.get(lottoResult);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
