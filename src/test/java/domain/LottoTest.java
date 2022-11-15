package domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("당첨번호와 몇 개가 일치하는지 확인")
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,45:5",
            "1,2,3,4,44,45:4",
            "1,2,3,43,44,45:3",
            "1,2,42,43,44,45:2",
            "1,41,42,43,44,45:1",
            "40,41,42,43,44,45:0"
    }, delimiter = ':')
    void compareToWinningNumber(String lotto, int count) {
        Lotto numbers = new Lotto(
                Stream.of(lotto.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(numbers.calculateSameCount(winningNumber)).isEqualTo(count);
    }
}
