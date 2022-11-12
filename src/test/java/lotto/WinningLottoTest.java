package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.utils.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 번호로 이루어진 로또를 생성한다.")
    @Test
    void createWinningLotto() {
        WinningLotto lotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        try {
            Field field = lotto.getClass().getDeclaredField("bonusNumber");
            field.setAccessible(true);

            int bonusNumber = (int) field.get(lotto);
            assertThat(bonusNumber).isEqualTo(7);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("입력한 보너스 번호가 로또 숫자의 범위가 아닌 경우 예외가 발생한다.")
    @Test
    void addBonusNumberByOverRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
    }

    @DisplayName("입력한 보너스 번호가 기존 번호와 중복된 경우 예외가 발생한다.")
    @Test
    void addBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HAVE_OVERLAP.getMessage());
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교한다. (보너스 번호 일치 시)")
    @Test
    void matchLottoByBonusNumberCorrect() {
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = new Lotto(List.of(2, 4, 6, 7, 15, 37));

        assertThat(winning.match(userLotto)).isEqualTo(List.of(3, true));
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교한다. (보너스 번호 미 일치 시)")
    @Test
    void matchLottoByBonusNumberUnCorrect() {
        WinningLotto winning = new WinningLotto(List.of(11, 15, 22, 26, 33, 44), 7);
        Lotto userLotto = new Lotto(List.of(2, 15, 26, 32, 37, 43));

        assertThat(winning.match(userLotto)).isEqualTo(List.of(2, false));
    }

}
