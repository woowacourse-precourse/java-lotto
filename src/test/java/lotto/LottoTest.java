package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행 로또의 개수가 1보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {
            -1
    })
    void issueLottoByLessThanOne(int number) {
        assertThatThrownBy(() -> Lotto.issueLotto(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행 로또 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "8, 8"
    })
    void issueLotto(int number, int numberOfLottos) {
        assertThat(Lotto.issueLotto(numberOfLottos).size()).isEqualTo(number);
    }
}
