package lotto.datamodel;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BonusLottoTest {
    @DisplayName("보너스 번호의 개수 로또 번호들 중 하나와 중복이 되면 예외가 발생한다.")
    @Test
    void createBonusLottoReduplication() {
        assertThatThrownBy(() -> new BonusLotto(5,List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1-45 범위를 벗어난 숫자면 예외가 발생한다")
    @Test
    void createBonusLottoByRange() {
        assertThatThrownBy(() -> new BonusLotto(60, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
