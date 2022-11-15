package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningTest {

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberDuplicatedWithLottoNumber() {
        LottoWinning.Builder builder = new LottoWinning.Builder();
        builder.winLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        builder.winBonus(6);

        assertThatThrownBy(builder::build)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberOutOfRange() {
        LottoWinning.Builder builder = new LottoWinning.Builder();
        builder.winLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        builder.winBonus(47);

        assertThatThrownBy(builder::build)
                .isInstanceOf(IllegalArgumentException.class);
    }
}