package lotto;

import controller.Compare;
import controller.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CompareTest {
    @DisplayName("당첨번호와 보너스 번호 내 중복이 있는지 확인")
    @Test
    void 번호_중복_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Compare.getIntegratedWinningNumber(List.of(1,2,3,4,5,6), List.of(1));
                })
                .withMessage("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Compare.getIntegratedWinningNumber(List.of(1,2,3,4,4,6), List.of(7));
                })
                .withMessage("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

    @DisplayName("당첨번호와 로또번호 일치하는 개수 확인")
    @Test
    void 번호일치_테스트() {
        assertThat(Compare.compareWithWinningNumber(List.of(1,2,3,4,5,6),List.of(1,3,5,7,24,30))).isEqualTo(3);
    }

    @DisplayName("로또번호에 보너스 번호 있는지 확인")
    @Test
    void 보너스번호_일치_테스트() {
        assertThat(Compare.compareWithBonusNumber(List.of(7), List.of(1,2,3,4,5,7))).isEqualTo(1);
        assertThat(Compare.compareWithBonusNumber(List.of(6), List.of(1,2,3,4,5,7))).isEqualTo(0);
    }
}
