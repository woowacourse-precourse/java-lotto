package lotto.model;

import lotto.Enum.Error;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("입력이 1부터 45 사이의 정수가 아닐 때 예외를 발생한다.")
    @Nested
    class ValidateRangeTest {
        @Test
        void case1() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,77", "1");
            });
            assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
        }
    }

    @DisplayName("보너스 숫자가 당첨번호와 중복이거나 1부터 45 사이의 정수가 아닐 때 예외를 발생한다")
    @Nested
    class ValidateBonusTest {
        @Test
        void case1() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "1");
            });
            assertEquals(Error.BONUS.getMessage(), exception.getMessage());
        }

        @Test
        void case2() {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "77");
            });
            assertEquals(Error.NUMBER.getMessage(), exception.getMessage());
        }
    }


}
