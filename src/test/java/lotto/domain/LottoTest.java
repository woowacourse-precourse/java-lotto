package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호의 개수가 5개면 예외가 발생한다.")
    @Test
    void createLottoWithFiveNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 7개면 예외가 발생한다.")
    @Test
    void createLottoWithSevenNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoWithSmallNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createLottoWithLargeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoWithDuplication() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 출력 형식을 확인한다.")
    @Test
    void toString_메서드_테스트() {
        Lotto lotto = new Lotto(List.of(37, 5, 22, 14, 6, 43));
        assertThat(lotto.toString())
                .isEqualTo("[5, 6, 14, 22, 37, 43]");
    }
}
