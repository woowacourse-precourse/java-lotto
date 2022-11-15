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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("금액이 1000으로 나누어지지 않으면 예외 발생")
    @Test
    void 금액입력_예외_테스트1() {
        assertSimpleTest(() -> {
            runException("1030");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("금액이 정수가 아니면 예외 발생")
    @Test
    void 금액입력_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("100aeb");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 금액입력_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
        );
    }



}
