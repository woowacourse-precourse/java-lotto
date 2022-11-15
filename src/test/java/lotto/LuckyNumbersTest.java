package lotto;

import lotto.model.Lotto;
import lotto.model.LuckyNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LuckyNumbersTest {
    @DisplayName("당첨번호와 보너스 번호 중복 시 예외 발생 확인.")
    @Test
    void createWinNumbers() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> new LuckyNumbers(lotto,3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 범위 밖일시 예외 발생 확인.")
    @Test
    void createBonusNumber() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> new LuckyNumbers(lotto,0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
