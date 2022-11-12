package lotto.helper.factory;

import java.lang.reflect.Field;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.helper.exception.CannotReflectionException;
import lotto.helper.util.ReflectionFieldUtils;
import lotto.util.ranking.LottoRanking;

public final class LottoResultTestFactory {

    private static final String RESULT_FIELD_NAME = "lottoRankingResult";

    private LottoResultTestFactory() {
    }

    public static LottoResult lottoRankingResultOf(Map<LottoRanking, Integer> lottoRankingResult) {
        Field lottoRankingResultField = ReflectionFieldUtils
                .processReflectionField(LottoResult.class, RESULT_FIELD_NAME);

        LottoResult lottoResult = new LottoResult();

        try {
            lottoRankingResultField.set(lottoResult, lottoRankingResult);
            return lottoResult;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
