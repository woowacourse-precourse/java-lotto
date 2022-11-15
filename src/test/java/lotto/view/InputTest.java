package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("금액 입력 테스트")
    @Nested
    class getAmountSuccess {

        @DisplayName("정상 실행")
        @Test
        void success1() {
            assertThat(InputView.getAmount("222000")).isEqualTo(222000);
        }

        @DisplayName("정상 실행")
        @Test
        void success2() {
            assertThat(InputView.getAmount("0")).isEqualTo(0);
        }

        @DisplayName("정상 실행")
        @Test
        void success3() {
            assertThat(InputView.getAmount("00123000")).isEqualTo(123000);
        }

        @DisplayName("예외 실행: 문자가 포함된 경우")
        @Test
        void fail1() {
            assertSimpleTest(() -> {
                runException("1000j");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("예외 실행: 문자가 포함된 경우")
        @Test
        void fail2() {
            assertSimpleTest(() -> {
                runException("1안3녕2하5세6요7");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("예외 실행: 1000원 단위가 아닌 경우")
        @Test
        void fail3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("123456"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("예외 실행: 음수가 입력된 경우")
        @Test
        void fail4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-112000"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("당첨 번호 입력 테스트")
    @Nested
    class getWinningNumberTest {

        @DisplayName("정상 실행")
        @Test
        void success1() {
            assertThat(InputView.getWinningNumber("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        }

        @DisplayName("예외 실행: 범위 밖의 수가 입력")
        @Test
        void fail1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getWinningNumber("-1,1,2123,3,4,5"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("예외 실행: 입력 갯수 부족")
        @Test
        void fail2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getWinningNumber("1,2,3,4"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("예외 실행: 입력 갯수 초과")
        @Test
        void fail3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getWinningNumber("1,2,3,4,6,7,8"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("예외 실행: 잘못된 값 입력")
        @Test
        void fail4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getWinningNumber("1.1,2,3,4,5,6"))
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("예외 실행: 잘못된 값 입력")
        @Test
        void fail5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getWinningNumber("1, 2, 3,3,4,5"))
                            .isInstanceOf(IllegalArgumentException.class));
        }
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Nested
    class getBonusNumberTest {

        @DisplayName("정상 실행")
        @Test
        void success1() {
            assertThat(InputView.getBonusNumber("1")).isEqualTo(1);
        }

        @DisplayName("예외 실행: 음수가 입력된 경우")
        @Test
        void success2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getBonusNumber("-112"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("예외 실행: 45보다 큰 수가 입력된 경우")
        @Test
        void success3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> InputView.getBonusNumber("47"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}
