package lotto.helper.util;

import java.lang.reflect.Field;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.helper.exception.CannotReflectionException;
import lotto.util.ranking.LottoRanking;

public final class LottoResultTestUtils {

    private static final String RESULT_FIELD_NAME = "lottoRankingResult";

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
}
