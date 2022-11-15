package lotto;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import lotto.Application.NumberType;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GetWinningNumbersMethodTest extends NsTest {
    @Test
    void getWinningNumbers_메소드_테스트1() {
        ArrayList<Integer> winningNumbers
                = new ArrayList<>(List.of(40, 41, 42, 43, 44, 45));
        initializeNumberType();
        assertSimpleTest(() -> {
            run("40,41,42,43,44,45");
            for (int number = 1; number <= 45; number++) {
                if(winningNumbers.contains(number))
                    assertThat(numberType[number]).isEqualTo(NumberType.WINNING);
                if(!winningNumbers.contains(number))
                    assertThat(numberType[number]).isNotEqualTo(NumberType.WINNING);
            }
        });
    }

    @Test
    void getWinningNumbers_메소드_예외_테스트1() {
            assertThatThrownBy(() -> {
                assertSimpleTest(() -> run("*212"));
            })
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    void getWinningNumbers_메소드_예외_테스트2() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("45, 37, 43, 21, 5, 17"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
    }

    @Test
    void getWinningNumbers_메소드_예외_테스트3() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("123"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getWinningNumbers_메소드_예외_테스트4() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234567890"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getWinningNumbers_메소드_예외_테스트5() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234,5678,3749,8352,797,5012"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getWinningNumbers_메소드_예외_테스트6() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("1234,5678,3749,8352,797,5012"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void getWinningNumbers_메소드_예외_테스트7() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> run("45,37,43,21,5,45"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호엔 중복된 숫자가 없어야 합니다.");
    }

    @Override
    public void runMain() {
        Application.getWinningNumbers();
    }
}