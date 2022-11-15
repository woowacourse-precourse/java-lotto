package lotto;

import controller.Calculate;
import controller.Compare;
import controller.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputNumberTest {
    @DisplayName("당첨번호가 제대로 파싱되는지 확인")
    @Test
    void 당첨번호_파싱_확인_테스트() {
        assertThat(InputNumber.parseWinningNumber("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 제대로 파싱되는지 확인")
    @Test
    void 보너스번호_파싱_확인_테스트() {
        assertThat(InputNumber.parseWinningNumber("7")).isEqualTo(List.of(7));
    }

    @DisplayName("당첨번호가 6개가 아닐 때 예외 발생하는지 확인")
    @Test
    void 당첨번호_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    InputNumber.parseWinningNumber("1,2,3,4,5,6,7");
                })
                .withMessage("[ERROR] 당첨번호는 6개여야 합니다.");
    }

    @DisplayName("보너스번호가 1개가 아닐 때 예외 발생하는지 확인")
    @Test
    void 보너스번호_예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    InputNumber.parseBonusNumber("2, 4");
                })
                .withMessage("[ERROR] 보너스 번호는 1개여야 합니다.");
    }

    @DisplayName("당첨번호와 보너스 번호 내 중복이 있는지 확인")
    @Test
    void 번호_중복_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    InputNumber.getIntegratedWinningNumber(List.of(1, 2, 3, 4, 5, 6), List.of(1));
                })
                .withMessage("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    InputNumber.getIntegratedWinningNumber(List.of(1, 2, 3, 4, 4, 6), List.of(7));
                })
                .withMessage("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

}
