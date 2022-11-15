package lotto.helper.util;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.player.Player;
import lotto.helper.exception.CannotReflectionException;

public final class PlayerTestUtils {

    private static final String MY_LOTTOS_FIELD_NAME = "myLottos";

    private PlayerTestUtils() {
    }

    @SuppressWarnings("unchecked")
    public static List<Lotto> findPlayerLottos(Player player) {
        Field myLottosField = ReflectionFieldUtils.processReflectionField(Player.class, MY_LOTTOS_FIELD_NAME);

        try {
            return (List<Lotto>) myLottosField.get(player);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
