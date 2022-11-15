package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application.NumberType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.initializeNumberType;
import static lotto.Application.numberType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GetBonusNumberMethodTest extends NsTest {
    ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호는 numberType 변수에 NumberType.BONUS 값이 할당된다(1).")
    @Test
    void getBonusNumberMethodTest1() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertSimpleTest(() -> {
            run("7");
            assertThat(numberType[7]).isEqualTo(NumberType.BONUS);
        });
    }

    @DisplayName("보너스 번호는 numberType 변수에 NumberType.BONUS 값이 할당된다(2).")
    @Test
    void getBonusNumberMethodTest2() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertSimpleTest(() -> {
            run("45");
            assertThat(numberType[45]).isEqualTo(NumberType.BONUS);
        });
    }

    @DisplayName("보너스 번호엔 숫자 외 입력이 불가하다(1).")
    @Test
    void getBonusNumberMethodExceptionTest1() {
            assertThatThrownBy(() -> {
                assertSimpleTest(() -> run("*"));
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("보너스 번호엔 숫자 외 입력이 불가하다(2).")
    @Test
    void getBonusNumberMethodExceptionTest2() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("neppiness"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @DisplayName("보너스 번호엔 9자리 이상 숫자가 입력이 불가하다.")
    @Test
    void getBonusNumberMethodExceptionTest3() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234567890"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @DisplayName("보너스 번호엔 45를 초과하는 자연수를 입력할 수 없다.")
    @Test
    void getBonusNumberMethodExceptionTest4() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("46"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @DisplayName("보너스 번호엔 0을 입력할 수 없다.")
    @Test
    void getBonusNumberMethodExceptionTest5() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("0"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @DisplayName("보너스 번호엔 당첨 번호와 동일한 번호를 입력할 수 없다.")
    @Test
    void getBonusNumberMethodExceptionTest6() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("6"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호가 아닌 다른 번호를 입력하십시오.");
    }

    @Override
    public void runMain() {
        Application.getBonusNumber();
    }
}