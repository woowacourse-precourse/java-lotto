import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;
import lotto.domain.PickBonusNum;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PickBonusNumTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복일 경우 예외 발생.")
    @Test
    void checkLottoDigit() {
        List<Integer> testLottoList = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(testLottoList);
        assertThatThrownBy(() -> new PickBonusNum(lotto, "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
