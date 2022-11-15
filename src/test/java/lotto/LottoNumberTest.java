package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호와 보너스 숫자에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1과 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new LottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
