package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 다른 글자가 들어가면 예외가 발생한다")
    @Test
    void createMoneyByNotNumber() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateMoneyType", String.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, "a1000"))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 들어가면 예외가 발생하지 않는다")
    @Test
    void createMoneyByNumber() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateMoneyType", String.class);
        method.setAccessible(true);

        assertThatNoException()
                .isThrownBy(() -> method.invoke(lottoGame, "1000"));
    }
}
