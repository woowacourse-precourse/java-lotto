package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest extends NsTest {
    @Nested
    @DisplayName("구매금액 입력에 관한 테스트")
    class AskForMoneyTest {
        @DisplayName("구입 금액이 숫자로만 이루어지지 않으면 예외가 발생한다.")
        @Test
        void checkOnlyNumberTest() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000j"))
                    .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
        @Test
        void checkDivisibleNumberTest() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1100"))
                    .isInstanceOf(IllegalArgumentException.class));
        }
    }

    @Nested
    @DisplayName("로또 구매에 관한 테스트")
    class BuyLottoTest {
        @DisplayName("구입 금액만큼 로또를 구매하는지 확인")
        @Test
        void checkBuyLottoForMoneyTest() {
            assertSimpleTest(() -> {
                run("8000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains("8개를 구매했습니다.");
            });
        }
    }

    @Nested
    @DisplayName("당첨번호 입력에 관한 테스트")
    class AskWinningNumberTest {
        @DisplayName("입력받은 당첨번호가 숫자로만 이루어지지 않았으면 예외가 발생한다.")
        @Test
        void checkArrayOnlyNumberTest() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,a", "7"))
                    .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("입력받은 당첨번호가 범위(1 ~ 45)를 넘어가면 예외가 발생한다.")
        @Test
        void createWinningLottoByOutOfRange() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,46", "7"))
                    .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("입력받은 당첨번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createWinningLottoByOverSize() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6,7", "7"))
                    .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("입력받은 당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createWinningLottoByDuplicatedNumber() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,1", "7"))
                    .isInstanceOf(IllegalArgumentException.class));
        }
    }

    @Nested
    @DisplayName("보너스번호 입력에 관한 테스트")
    class AskBonusNumberTest {
        @DisplayName("보너스번호가 숫자가 아닌 경우 예외가 발생한다.")
        @Test
        void createBonusNumberNotNumber() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6", "a"))
                    .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("보너스번호가 범위(1~45)를 벗어난 경우 예외가 발생한다.")
        @Test
        void checkOutOfRangeTest() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6", "47"))
                    .isInstanceOf(IllegalArgumentException.class));
        }

        @DisplayName("보너스번호가 당첨번호와 중첩되는 경우 예외가 발생한다.")
        @Test
        void createBonusNumberByDuplicatedWinningNumber() {
            assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6", "6"))
                    .isInstanceOf(IllegalArgumentException.class));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
