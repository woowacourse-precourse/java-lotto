package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호를 오름차순으로 정렬하여 출력한다.")
    @Test
    void printLottoByAscendingOrder() {
        Lotto lotto = new Lotto(List.of(6, 1, 2, 3, 4, 5));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 여부 매칭")
    @ParameterizedTest
    @MethodSource("generateMatchData")
    void match(Rank rank, List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLottoNumbers, bonusNumber);
        assertThat(lotto.match(winningNumbers)).isEqualTo(rank);
    }

    private static Stream<Arguments> generateMatchData() {
        return Stream.of(
                Arguments.of(Rank.FIRST, List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(Rank.SECOND, List.of(1, 2, 3, 4, 6, 7)),
                Arguments.of(Rank.THIRD, List.of(1, 2, 3, 5, 6, 10)),
                Arguments.of(Rank.FOURTH, List.of(1, 2, 3, 6, 40, 41)),
                Arguments.of(Rank.FIFTH, List.of(1, 5, 6, 10, 20, 30)),
                Arguments.of(Rank.OUT, List.of(1, 6, 8, 9, 10, 11)),
                Arguments.of(Rank.OUT, List.of(1, 7, 8, 9, 10, 11)),
                Arguments.of(Rank.OUT, List.of(7, 8, 9, 10, 11, 12))
        );
    }
}
