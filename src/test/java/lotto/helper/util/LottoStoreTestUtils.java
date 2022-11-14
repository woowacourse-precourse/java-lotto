package lotto.helper.util;

import java.lang.reflect.Field;
import lotto.domain.number.Lotto;
import lotto.mvc.model.LottoStore;
import lotto.domain.player.Player;
import lotto.helper.exception.CannotReflectionException;

public final class LottoStoreTestUtils {

    private static final String PLAYER_FIELD_NAME = "player";
    private static final String WINNING_LOTTO_FIELD_NAME = "winningLotto";

    private LottoStoreTestUtils() {
    }

    public static Player findPlayer(LottoStore lottoStore) {
        Field playerField = ReflectionFieldUtils.processReflectionField(LottoStore.class, PLAYER_FIELD_NAME);

        try {
            return (Player) playerField.get(lottoStore);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }

    public static Lotto findWinningLotto(LottoStore lottoStore) {
        Field winningLotto = ReflectionFieldUtils.processReflectionField(LottoStore.class, WINNING_LOTTO_FIELD_NAME);

        try {
            return (Lotto) winningLotto.get(lottoStore);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
