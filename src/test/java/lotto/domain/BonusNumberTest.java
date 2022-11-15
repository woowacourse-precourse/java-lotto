package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또에 포함되어 있으면 True를 반환한다.")
    @Test
    void bonusNumberDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);

        boolean duplicate = bonusNumber.isContain(lotto);

        assertThat(duplicate).isTrue();
    }

    @DisplayName("보너스 번호가 로또에 포함되어 있지 않으면 False를 반환한다.")
    @Test
    void bonusNumberNotDuplicate() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        boolean duplicate = bonusNumber.isContain(lotto);

        assertThat(duplicate).isFalse();
    }
}