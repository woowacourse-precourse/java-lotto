package lotto;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 몇개가 일치하는지 확인")
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,7:5",
            "1,2,3,4,7,8:4",
            "1,2,3,7,8,9:3",
            "1,2,7,8,9,10:2",
            "1,7,8,9,10,11:1",
            "7,8,9,10,11,12:0"
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
