package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final List<Integer> COMPUTER = List.of(8, 21, 23, 41, 42, 43);

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

    @DisplayName("컴퓨터의 수와 플레이어의 수를 비교해서 몇 개의 숫자가 일치하는 지 알 수 있다")
    @ParameterizedTest
    @MethodSource("providePlayers")
    void isEqualCorrectCount(Lotto player, int expected) {
        int actual = player.getMatchingNumber(COMPUTER);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> providePlayers() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)), Named.of("6개 번호 일치", 6)),
                Arguments.of(new Lotto(List.of(4, 21, 23, 41, 42, 43)), Named.of("5개 번호 일치", 5)),
                Arguments.of(new Lotto(List.of(4, 1, 23, 41, 42, 43)), Named.of("4개 번호 일치", 4)),
                Arguments.of(new Lotto(List.of(4, 1, 3, 41, 42, 43)), Named.of("3개 번호 일치", 3)),
                Arguments.of(new Lotto(List.of(4, 1, 3, 18, 42, 43)), Named.of("2개 번호 일치", 2)),
                Arguments.of(new Lotto(List.of(4, 1, 3, 18, 7, 43)), Named.of("1개 번호 일치", 1)),
                Arguments.of(new Lotto(List.of(4, 1, 3, 18, 7, 39)), Named.of("0개 번호 일치", 0))
        );
    }

}
