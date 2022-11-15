package lotto;

import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또는 유효하게 생성된다.")
    @Test
    void createAndGetLotto() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> actual = new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers()
                .stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByBelowSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 허용 범위보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByLowerNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 0, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 허용 범위보다 크면 예외가 발생한다.")
    @Test
    void createLottoByUpperNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Getter로 가져온 로또 한 줄에 번호를 추가하려고 하면 예외가 발생한다.")
    @Test
    void getLottoNumbersForAddMoreNumber() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6))
                    .getNumbers().add(new LottoNumber(32));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("Getter로 가져온 로또 한 줄에 번호를 제거하려고 하면 예외가 발생한다.")
    @Test
    void getLottoNumbersForReplaceNumber() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers().remove(0);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

}
