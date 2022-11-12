package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    private static final Lotto lotto = new Lotto("1,2,3,4,5,6");

    @DisplayName("보너스 번호 입력 - 정상 값 입력")
    @Test
    void checkBonusNormalInput() {
        String inputNumber = "7";

        BonusNumber bonusNumber = new BonusNumber(inputNumber, lotto);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스 번호 입력 - 빈 값 입력 시 예외 발생")
    @Test
    void checkBonusNullInput() {
        String inputNumber = "";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 띄어쓰기만 입력 시 예외 발생")
    @Test
    void checkBonusSpaceInput() {
        String inputNumber = "   ";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 문자열 입력 시 예외 발생")
    @Test
    void checkBonusStringInput() {
        String inputNumber = "abc";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 숫자와 문자열 입력 시 예외 발생")
    @Test
    void checkBonusNumberWithStringInput() {
        String inputNumber = "1a";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 45 초과 값 입력 시 예외 발생")
    @Test
    void checkBonusOver45Input() {
        String inputNumber = "46";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 1 미만 값 입력 시 예외 발생")
    @Test
    void checkBonusUnder1Input() {
        String inputNumber = "0";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 이 기능 추가
    @DisplayName("보너스 번호 입력 - 두 개의 값 입력 시 예외 발생")
    @Test
    void checkBonusTwoNumbersInput() {
        String inputNumber = "1 2";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 이 기능 추가
    @DisplayName("보너스 번호 입력 - 두 개의 값 입력 시 예외 발생")
    @Test
    void checkBonusTwoNumbersWithCommaInput() {
        String inputNumber = "1,2";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 - 당첨 번호에 있는 값 입력 시 예외 발생")
    @Test
    void checkBonusInLottoInput() {
        String inputNumber = "1";

        assertThatThrownBy(() -> new BonusNumber(inputNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
