package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application.NumberType;
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

    @Test
    void getBonusNumber_메소드_테스트1() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertSimpleTest(() -> {
            run("7");
            assertThat(numberType[7]).isEqualTo(NumberType.BONUS);
        });
    }

    @Test
    void getBonusNumber_메소드_테스트2() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertSimpleTest(() -> {
            run("45");
            assertThat(numberType[45]).isEqualTo(NumberType.BONUS);
        });
    }

    @Test
    void getBonusNumber_메소드_예외_테스트1() {
            assertThatThrownBy(() -> {
                assertSimpleTest(() -> run("*"));
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void getBonusNumber_메소드_예외_테스트2() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234567890"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getBonusNumber_메소드_예외_테스트3() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("46"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getBonusNumber_메소드_예외_테스트4() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("0"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getBonusNumber_메소드_예외_테스트5() {
        initializeNumberType();
        new Lotto(winningNumbers);

        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("6"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호가 아닌 다른 번호를 입력하십시오.");
    }

    @Test
    void getBonusNumber_메소드_예외_테스트6() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("neppiness"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Override
    public void runMain() {
        Application.getBonusNumber();
    }
}