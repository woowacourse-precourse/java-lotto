package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private static final String ERROR_PREFIX_MASSAGE = "[ERROR] ";
    private static final String ERROR_DUPLICATE_MASSAGE = "로또 번호에 중복된 숫자는 없습니다.";
    private static final String ERROR_RANGE_MASSAGE = "로또 번호는 1부터 45까지입니다.";
    private Lotto lotto;

    @DisplayName("보너스 번호는 중복되면 안 된다.")
    @Test
    void 보너스_번호_검증_테스트() {
        lotto = new Lotto(new ArrayList<>(List.of(6, 2, 3, 4, 1, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(lotto, 6);
        }).withMessageContaining(ERROR_PREFIX_MASSAGE + ERROR_DUPLICATE_MASSAGE);
    }

    @DisplayName("보너스 번호는 45이하여야 한다")
    @Test
    void 보너스_번호_최대범위_테스트() {
        lotto = new Lotto(new ArrayList<>(List.of(6, 2, 3, 4, 1, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(lotto, 46);
        }).withMessageContaining(ERROR_PREFIX_MASSAGE + ERROR_RANGE_MASSAGE);
    }

    @DisplayName("보너스 번호는 1이상이어야 한다.")
    @Test
    void 보너스_번호_최소범위_테스트() {
        lotto = new Lotto(new ArrayList<>(List.of(6, 2, 3, 4, 1, 5)));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto(lotto, 0);
        }).withMessageContaining(ERROR_PREFIX_MASSAGE + ERROR_RANGE_MASSAGE);
    }
}
