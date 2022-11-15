package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constant.ExceptionConstants;
import lotto.constant.GameConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest extends NsTest {

    @DisplayName("당첨 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreNotNaturalNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,a");
            assertThat(output()).contains(ExceptionConstants.NOT_NATURAL_NUMBER.toString());
        });
    }

    @DisplayName("당첨 번호가 0으로 시작하면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersWithLeadingZero() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,06");
            assertThat(output()).contains(ExceptionConstants.LEADING_ZERO.toString());
        });
    }

    @DisplayName("당첨 번호가 5개이면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfFiveWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output())
                    .contains(String.format(ExceptionConstants.WRONG_LENGTH.toString(),
                            GameConstants.WINNING_NUMBERS_LENGTH));
        });
    }

    @DisplayName("당첨 번호가 7개이면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfSevenWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output())
                    .contains(String.format(ExceptionConstants.WRONG_LENGTH.toString(),
                            GameConstants.WINNING_NUMBERS_LENGTH));
        });
    }

    @DisplayName("당첨 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreOverMax() {
        assertSimpleTest(() -> {
            runException("1000", "41,42,43,44,45,46");
            assertThat(output()).contains(ExceptionConstants.WRONG_RANGE.toString());
        });
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfWinningNumbersAreDuplicated() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ExceptionConstants.DUPLICATION.toString());
        });
    }

    @DisplayName("보너스 번호가 자연수가 아니면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfBonusNumberIsNotNaturalNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ExceptionConstants.NOT_NATURAL_NUMBER.toString());
        });
    }

    @DisplayName("보너스 번호가 0으로 시작하면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfBonusNumberWithLeadingZero() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "07");
            assertThat(output()).contains(ExceptionConstants.LEADING_ZERO.toString());
        });
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfBonusNumberIsOverMax() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ExceptionConstants.WRONG_RANGE.toString());
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfBonusNumberIsDuplicated() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "3");
            assertThat(output()).contains(ExceptionConstants.DUPLICATION.toString());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
