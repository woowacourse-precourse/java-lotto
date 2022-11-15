package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

class LottoAdminTest {

    LottoAdmin lottoAdmin = new LottoAdmin();

    @DisplayName("당첨 번호 정상 입력 값을 입력하면 당첨 번호가 담겨있는 Set의 사이즈는 6이 된다.")
    @Test
    void createWinningNumbers() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,2,3,4,5,6";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);

            lottoAdmin.createWinningNumbers();

            assertThat(lottoAdmin.getWinningNumber()).hasSize(6);
        }
    }

    @DisplayName("당첨 번호 숫자 범위 이외의 값 입력시 예외 발생한다.")
    @ParameterizedTest
    @CsvSource({"0,1,2,3,4,5", "45,1,2,3,4,5", "-1,1,2,3,4,5"})
    void inputWinningNumbersByIllegalRange(String number1, String numbers2, String numbers3, String number4,
            String numbers5, String numbers6) {

        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String illegalRangeNumbers = number1 + numbers2 + numbers3 + number4 + numbers5 + numbers6;
            when(Console.readLine()).thenReturn(illegalRangeNumbers);

            assertThatThrownBy(() -> lottoAdmin.createWinningNumbers()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("당첨 번호 숫자 이외의 값 입력시 예외 발생한다.")
    @Test
    void inputWinningNumbersByIllegalValue() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "s,2,3,4,5,6";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);

            assertThatThrownBy(() -> lottoAdmin.createWinningNumbers()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("당첨 번호 숫자 중복 값 입력시 예외 발생한다.")
    @Test
    void inputWinningNumbersByOverlapWinningNumbers() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,1,1,1,1,1";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);

            assertThatThrownBy(() -> lottoAdmin.createWinningNumbers()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("당첨 번호 숫자 6자리 이하 입력시 예외 발생.")
    @Test
    void inputWinningNumbersBySixUnderInputNumbers() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,2,3,4,5";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);

            assertThatThrownBy(() -> lottoAdmin.createWinningNumbers()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("보너스 번호 정상 입력 테스트시 List에 담겨있는 사이즈는 1이다.| 전제 조건: 당첨 번호 존재")
    @Test
    void createBonusNumber() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,2,3,4,5,6";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);
            lottoAdmin.createWinningNumbers();

            String testInputBonusNumber = "7";
            when(Console.readLine()).thenReturn(testInputBonusNumber);
            lottoAdmin.createBonusNumber();

            assertThat(lottoAdmin.getBonusNumber()).hasSize(1);
        }
    }

    @DisplayName("보너스 번호 범위 이외의 값 입력시 예외처리 | 전제 조건: 당첨 번호 존재")
    @ParameterizedTest
    @CsvSource({"0","46","-1"})
    void inputBonusNumberIllegalRange(String number1) {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,2,3,4,5,6";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);
            lottoAdmin.createWinningNumbers();

            when(Console.readLine()).thenReturn(number1);

            assertThatThrownBy(() -> lottoAdmin.createBonusNumber()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("보너스 번호 중복 입력 시 예외처리 | 전제 조건: 당첨 번호 존재")
    @Test
    void inputBonusNumberOverlapWithWinningNumbers() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,2,3,4,5,6";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);
            lottoAdmin.createWinningNumbers();

            String testOverlapBonusNumber = "6";
            when(Console.readLine()).thenReturn(testOverlapBonusNumber);

            assertThatThrownBy(() -> lottoAdmin.createBonusNumber()).hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("보너스 번호 숫자 이외의 값 입력시 예외처리 | 전제 조건: 당첨 번호 존재")
    @Test
    void inputBonusNumberIllegalValue() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testInputWinningNumbers = "1,2,3,4,5,6";
            when(Console.readLine()).thenReturn(testInputWinningNumbers);
            lottoAdmin.createWinningNumbers();

            String testOverlapBonusNumber = "s";
            when(Console.readLine()).thenReturn(testOverlapBonusNumber);

            assertThatThrownBy(() -> lottoAdmin.createBonusNumber()).hasMessageContaining("[ERROR]");
        }
    }

}
