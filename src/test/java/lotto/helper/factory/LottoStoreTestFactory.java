package lotto.helper.factory;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.player.LottoPurchaseAmount;
import lotto.mvc.model.LottoStore;
import lotto.domain.player.Player;
import lotto.helper.exception.CannotReflectionException;
import lotto.helper.stub.StubWinningLotto;
import lotto.helper.util.ReflectionFieldUtils;
import lotto.mvc.util.LottoRanking;

public final class LottoStoreTestFactory {

    private static final String PLAYER_FIELD_NAME = "player";
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

    public static LottoStore playerOf(Player player) {
        LottoStore lottoStore = new LottoStore(new LottoPurchaseAmount("1000"));
        Field playerField = ReflectionFieldUtils.processReflectionField(LottoStore.class, PLAYER_FIELD_NAME);

        try {
            playerField.set(lottoStore, player);
            return lottoStore;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
