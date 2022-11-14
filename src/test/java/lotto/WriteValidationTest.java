package lotto;

import lotto.dto.WinningLottoNumber;
import lotto.exception.ErrorCode;
import lotto.service.WriteValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WriteValidationTest {

    private WriteValidation validation = new WriteValidation();

    @Test
    @DisplayName("유효한 금액 데이터를 입력하여 테스트 성공")
    void writePay_case1() {
        // given
        String writePay = "8000";
        int expectedPay = 8000;

        // when
        int pay = validation.writePay(writePay);

        // then
        assertThat(pay).isEqualTo(expectedPay);
    }

    @Test
    @DisplayName("유효하지 않은 데이터를 입력하여 예외 발생")
    void writePay_case2() {
        // given
        String writePay = "8000원";

        // when && then
        assertThatThrownBy(() -> validation.writePay(writePay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("유효한 당첨번호 6개를 입력하고 보너스 번호 1개를 입력하여 테스트 성공")
    void winningLottoNumbers_case1() {
        // given
        String writeLottoNumber = "1,2,3,4,5,6";
        String writeBonusNumber = "7";

        List<Integer> expectedLottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int expectedBonusNumber = 7;

        // when
        WinningLottoNumber winningLottoNumber = validation.writeWinningLottoNumbers(writeLottoNumber, writeBonusNumber);

        // then
        assertThat(expectedLottoNumber).isEqualTo(winningLottoNumber.getWinningNumbers());
        assertThat(expectedBonusNumber).isEqualTo(winningLottoNumber.getBonusNumber());
    }

    @Test
    @DisplayName("중복된 당첨 로또 번호를 입력하여 IllegalArgumentException 예외 발생")
    void winningLottoNumbers_case2() {
        // given
        String writeLottoNumber = "1,2,3,4,5,5";
        String writeBonusNumber = "7";

        // when && then
        assertThatThrownBy(() -> validation.writeWinningLottoNumbers(writeLottoNumber, writeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("2개 이상의 로또 번호를 입력하여 IllegalArgumentException 예외 발생")
    void winningLottoNumbers_case3() {
        // given
        String writeLottoNumber = "1,2,3,4,5,6";
        String writeBonusNumber = "7,1";

        // when && then
        assertThatThrownBy(() -> validation.writeWinningLottoNumbers(writeLottoNumber, writeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 입력시 번호의 범위에 벗어나 IllegalArgumentException 예외 발생")
    void winningLottoNumbers_case4() {
        // given
        String writeLottoNumber = "1,2,3,4,5,6";
        String writeBonusNumber = "46";

        // when && then
        assertThatThrownBy(() -> validation.writeWinningLottoNumbers(writeLottoNumber, writeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }
}