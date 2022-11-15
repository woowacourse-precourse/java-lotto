package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        assertThat(Lotto.issueLotto(numberOfLottos).getSize()).isEqualTo(number);
    }

    @ParameterizedTest
    @DisplayName("당첨 결과 확인")
    @CsvSource(value = {
            "8,21,23,41,42,43:0",
            "3,5,11,16,32,38 :2",
            "7,11,16,35,36,44:0",
            "1,8,11,31,41,42:1",
            "13,14,16,38,42,45:0",
            "7,11,30,40,42,43:0",
            "2,13,22,32,38,45:1"
    },delimiter = ':')
    void count(String lotto, int count) {
        Lotto user = new Lotto(
                Stream.of(lotto.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(user.count(winningNumber)).isEqualTo(count);
    }
}
