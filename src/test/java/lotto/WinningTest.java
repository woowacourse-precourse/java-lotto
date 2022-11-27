package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WinningTest {

    Winning winning = new Winning();

    @DisplayName("당첨 번호 테스트")
    @Nested
    class WinningNumberTest {

        @DisplayName("정상 입력 테스트")
        @Test
        void 당첨번호_정상입력() {
            assertDoesNotThrow(() -> winning.setWinningNumbers("1,44,21,28,19,4"));
            assertEquals(List.of(1,44,21,28,19,4), winning.getWinning());
        }

        @DisplayName("당첨 번호 문자 입력시 예외 발생")
        @Test
        void 당첨번호_문자포함() {
            assertThrows(IllegalArgumentException.class, () -> winning.setWinningNumbers("1,44,21,28,19,d"));
        }

        @DisplayName("당첨 번호 다른 구분자 예외")
        @Test
        void 당첨번호_구분자예외() {
            assertThrows(IllegalArgumentException.class, () -> winning.setWinningNumbers("1.44.21.28.19.11"));
        }

        @DisplayName("당첨 번호 길이 예외")
        @Test
        void 당첨번호_길이예외() {
            assertThrows(IllegalArgumentException.class, () -> winning.setWinningNumbers("1,44,21,28,19"));
        }

        @DisplayName("당첨 번호 범위 예외")
        @Test
        void 당첨번호_범위예외() {
            assertThrows(IllegalArgumentException.class, () -> winning.setWinningNumbers("1,0,21,28,19"));
        }
    }

    @DisplayName("보너스 번호 테스트")
    @Nested
    class 보너스번호 {

        @BeforeEach
        void beforEach() {
            winning.setWinningNumbers("1,44,21,28,19,4");
        }

        @DisplayName("정상 테스트")
        @Test
        void 보너스번호_정상() {
            assertDoesNotThrow(() -> winning.setBonusNumber("19"));
            assertEquals(19, winning.getBonusNumber());
        }

        @DisplayName("보너스번호 문자입력 예외")
        @Test
        void 보너스번호_문자입력() {
            assertThrows(IllegalArgumentException.class, () -> winning.setBonusNumber(" "));
        }

        @DisplayName("보너스번호 미입력 예외")
        @Test
        void 보너스번호_미입력() {
            assertThrows(IllegalArgumentException.class, () -> winning.setBonusNumber(""));
        }

        @DisplayName("보너스번호 범위 예외")
        @Test
        void 보너스번호_범위() {
            assertThrows(IllegalArgumentException.class, () -> winning.setBonusNumber("46"));
            assertThrows(IllegalArgumentException.class, () -> winning.setBonusNumber("0"));
        }
    }
}
