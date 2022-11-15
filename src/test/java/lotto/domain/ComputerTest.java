package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionConstants.*;
import static org.assertj.core.api.Assertions.*;

public class ComputerTest extends NsTest {

    @DisplayName("당첨 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void createComputerWithNotNaturalNumber() {
        String input = "1,2,3,4,5,a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 0으로 시작하면 예외가 발생한다.")
    @Test
    void createComputerWithLeadingZero() {
        String input = "1,2,3,4,5,06";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 5개이면 예외가 발생한다.")
    @Test
    void createComputerWithFiveNumbers() {
        String input = "1,2,3,4,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 7개이면 예외가 발생한다.")
    @Test
    void createComputerWithSevenNumbers() {
        String input = "1,2,3,4,5,6,7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createComputerWithSmallNumber() {
        String input = "0,1,2,3,4,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createComputerWithLargeNumber() {
        String input = "41,42,43,44,45,46";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void createComputerWithDuplication() {
        String input = "1,2,3,4,5,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Computer::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void inputNotNaturalBonusNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(NOT_NATURAL_NUMBER_EXCEPTION.toString());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
