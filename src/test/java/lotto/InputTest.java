package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @DisplayName("구입금액 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 구입금액이_1000원으로_나누어_떨어지지_않는_경우_예외_발생() {
        assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 금액 단위입니다.");
    }

    @DisplayName("당첨번호를 6개 입력하지 않으면 예외 발생")
    @Test
    void 당첨번호를_6개_입력하지_않으면_예외_발생() {
        assertThatThrownBy(() -> InputView.isValidFormat("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }

    @DisplayName("허용되지 않은 당첨번호 형식 입력 시 예외 발생")
    @Test
    void 허용되지_않은_당첨번호_값_입력_시_예외_발생() {
        assertThatThrownBy(() -> InputView.isValidFormat("/1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다.");
    }

    @DisplayName("당첨번호 범위를 초과할 경우 예외 발생")
    @Test
    void 당첨번호_범위를_초과할_경우_예외_발생() {
        assertThatThrownBy(() -> InputView.isValidFormat("100,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호의 범위를 초과했습니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아닌 다른 값이나 허용 숫자 범위를 초과하는 경우 예외 발생")
    @Test
    void 보너스_번호가_유효하지_않을_경우_예외_발생() {
        assertThatThrownBy(() -> InputView.isValidBonusNumber("one"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다.");

        assertThatThrownBy(() -> InputView.isValidBonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스번호의 범위를 초과했습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
