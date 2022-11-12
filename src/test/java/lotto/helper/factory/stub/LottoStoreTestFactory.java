package lotto.helper.factory.stub;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoStore;
import lotto.helper.exception.CannotReflectionException;
import lotto.helper.util.ReflectionFieldUtils;
import lotto.util.ranking.LottoRanking;

public final class LottoStoreTestFactory {

    private static final String WINNING_LOTTO_FIELD_NAME = "winningLotto";

    private LottoStoreTestFactory() {
    }

    public static LottoStore lottoRankingsLottoOf(List<LottoRanking> rankings, String amountInput) {
        LottoStore lottoStore = new LottoStore(new LottoPurchaseAmount(amountInput));
        StubWinningLotto stubWinningLotto = new StubWinningLotto(rankings);

        Field winningLottoField = ReflectionFieldUtils
                .processReflectionField(LottoStore.class, WINNING_LOTTO_FIELD_NAME);

        try {
            winningLottoField.set(lottoStore, stubWinningLotto);
            return lottoStore;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
