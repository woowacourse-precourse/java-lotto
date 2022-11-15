package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import lotto.data.entity.WinNumber;
import lotto.data.entity.WinNumber.WinNumberBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호에 대해서,")
public class WinNumberTest {

    @DisplayName("당첨 번호의 개수는 6개이다.")
    @Test
    void createWinNumberByOversize () {
        WinNumberBuilder winNumberBuilder = WinNumber.builder()
                .winNumbers(Set.of(1,2,3,4,5,6,7))
                .bonusNumber(10);
        assertThatThrownBy(() -> winNumberBuilder.build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위는 1 ~ 45이다.")
    @Test
    void createWinNumberOutOfRange() {
        WinNumberBuilder winNumberBuilder = WinNumber.builder()
                .winNumbers(Set.of(1,2,3,4,5,46))
                .bonusNumber(10);
        assertThatThrownBy(() -> winNumberBuilder.build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위는 1 ~ 45이다.")
    @Test
    void createBonusNumberOutOfRange() {
        WinNumberBuilder winNumberBuilder = WinNumber.builder()
                .winNumbers(Set.of(1,2,3,4,5,6))
                .bonusNumber(50);
        assertThatThrownBy(() -> winNumberBuilder.build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호는 겹치지 않는다.")
    @Test
    void createBonusNumberByDuplicate() {
        WinNumberBuilder winNumberBuilder = WinNumber.builder()
                .winNumbers(Set.of(1,2,3,4,5,6))
                .bonusNumber(1);
        assertThatThrownBy(() -> winNumberBuilder.build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호 모두 받아야 한다.")
    @Test
    void creatWinNumberWithoutBonusNumber() {
        WinNumberBuilder winNumberBuilder = WinNumber.builder()
                .winNumbers(Set.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> winNumberBuilder.build())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
