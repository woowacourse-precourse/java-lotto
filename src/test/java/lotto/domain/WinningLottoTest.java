package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 번호의 개수가 이전에 입력된 로또의 숫자와 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void createLottoByOverSize(int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 범위의 숫자가 범위안에 포함되지 않으면 에외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createLottoByDuplicatedNumber(int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

}