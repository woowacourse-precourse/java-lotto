package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Result(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createDuplicatedLottoNumbers() {
        assertThatThrownBy(() -> new Result(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void inputNumbersOutOfRange() {
        assertThatThrownBy(() -> new Result(List.of(1, 2, 3, 4, 50, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void bonusNumbersOutOfRange() {
        Result result = new Result(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> result.setBonus(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 중복될 경우에 예외가 발생한다.")
    @Test
    void bonusNumbersDuplicated() {
        Result result = new Result(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> result.setBonus(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}