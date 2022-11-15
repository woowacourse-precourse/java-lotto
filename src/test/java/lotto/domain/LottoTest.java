package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 이미 존재하면 예외가 발생한다.")
    @Test
    void generateBonusByDuplicatedDrawNumber() {
        assertThatThrownBy(() -> Lotto.generate(Lotto.generate("1,2,3,4,5,6"), "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1이상 45이하 범위에 속하지 않으면 예외가 발생한다.")
    @Test
    void generateBonusByOverRange() {
        assertThatThrownBy(() -> Lotto.generate(Lotto.generate("1,2,3,4,5,6"), "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
