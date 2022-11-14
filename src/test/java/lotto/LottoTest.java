package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구입 금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    void 예외_테스트1() {
        assertSimpleTest(() -> {
            runException("500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않을때 예외가 발생한다.")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("5500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 숫자가 아닐 때 예외 발생")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() -> {
            runException("20j1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호가 1보다 작을 때 예외 발생")
    @Test
    void 예외_테스트4() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, -1, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 클때 예외 발생")
    @Test
    void 예외_테스트5() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, -1, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
