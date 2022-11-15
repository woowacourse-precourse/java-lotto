package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    @Test
    @DisplayName("로또 구입 금액만큼 로또 개수를 계산하면 성공이다.")
    void getLottoAmountAsMoney() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        int money = 14000;

        LottoGame lottoGame = new LottoGame(money);

        Field field = lottoGame.getClass().getDeclaredField("amount");
        field.setAccessible(true);

        int lottoAmount = (int) field.get(lottoGame);

        Method method = lottoGame.getClass().getDeclaredMethod("getLottoAmount", Money.class);
        method.setAccessible(true);
        method.invoke(lottoGame, new Money(money));

        assertThat(lottoAmount).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 구입 금액만큼 로또를 생성하면 성공이다.")
    void createLottosAsLottoAmount() throws NoSuchFieldException, IllegalAccessException {
        int money = 14000;

        LottoGame lottoGame = new LottoGame(money);

        Field field = lottoGame.getClass().getDeclaredField("lottos");
        field.setAccessible(true);
        Lottos lottos = (Lottos) field.get(lottoGame);

        assertThat(lottos.getLottos()).hasSize(14);
    }
}