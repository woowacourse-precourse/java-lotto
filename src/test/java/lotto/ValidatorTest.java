package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize(){
        assertThatThrownBy(() -> validator.validateLottoLength(new String[]{"1", "2", "3", "4", "5", "6","7"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() ->  validator.validateDuplicate(new String[]{"1", "2", "3", "4", "5", "5"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // 아래에 추가 테스트 작성 가능
    @DisplayName("금액이 1000원 미만이면 예외 발생.")
    @Test
    void 금액미달() {
        assertThatThrownBy(() ->  validator.validateMoney(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위가 아니면 예외 발생.")
    @Test
    void 단위오류() {
        assertThatThrownBy(() ->  validator.validateMoney(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 여러 개 입력되면 예외 발생.")
    @Test
    void 보너스번호갯수오류() {
        assertThatThrownBy(() ->  validator.validateBonusOneNumber("3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호의 값이 1보다 작거나 45보다 크면 예외 발생.")
    @Test
    void 보너스번호1미만() {
        assertThatThrownBy(() ->  validator.validateBonusRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호의 값이 1보다 작거나 45보다 크면 예외 발생.")
    @Test
    void 보너스번호45초과() {
        assertThatThrownBy(() ->  validator.validateBonusRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호와 당첨 번호가 중복되면 예외 발생.")
    @Test
    void 보너스번호와당첨번호중복() {
        assertThatThrownBy(() ->  validator.validateBonus("1", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1보다 작거나 45보다 크면 예외 발생.")
    @Test
    void 당첨번호범위오류() {
        assertThatThrownBy(() ->  validator.validateNumbersRange(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액에 숫자가 아닌 문자가 입력되면 예외 발생.")
    @Test
    void 금액입력오류() {
        assertThatThrownBy(() ->  validator.validateMoneyOnlyNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}