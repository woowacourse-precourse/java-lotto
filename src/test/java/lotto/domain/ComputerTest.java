package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionConstants.*;
import static org.assertj.core.api.Assertions.*;

public class ComputerTest extends NsTest {

    @DisplayName("당첨 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreNotNaturalNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,a");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("당첨 번호가 0으로 시작하면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersWithLeadingZero() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,06");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("당첨 번호가 5개이면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfFiveWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("당첨 번호가 7개이면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfSevenWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("당첨 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreUnderMin() {
        assertSimpleTest(() -> {
            runException("1000", "0,1,2,3,4,5");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("당첨 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreOverMax() {
        assertSimpleTest(() -> {
            runException("1000", "41,42,43,44,45,46");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreDuplicated() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(DUPLICATED_EXCEPTION.toString());
        });
    }

    @DisplayName("보너스 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfBonusNumberIsNotNaturalNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(NOT_NATURAL_NUMBER_EXCEPTION.toString());
        });
    }

    @DisplayName("보너스 번호가 0으로 시작하면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfBonusNumberWithLeadingZero() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "07");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
